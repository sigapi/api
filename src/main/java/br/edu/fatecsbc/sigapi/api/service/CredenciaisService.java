package br.edu.fatecsbc.sigapi.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import br.edu.fatecsbc.sigapi.conector.CredenciaisBuilder;
import br.edu.fatecsbc.sigapi.conector.dto.Credenciais;
import br.edu.fatecsbc.sigapi.conector.selenium.CredenciaisSeleniumBuilder;

@Service
public class CredenciaisService {

    @Autowired
    private ConectorService service;

    /**
     * Cria as credenciais de acesso ao conector, de acordo com o usuário logado
     *
     * @return {@link Credenciais} preenchidas
     */
    public Credenciais getCredenciais() {

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final Object principal = authentication.getPrincipal();
        final User user = (User) principal;

        return getCredenciais(user.getUsername(), user.getPassword());

    }

    /**
     * Cria as credenciais de acesso ao conector
     *
     * @param usuario
     *            Usuário
     * @param senha
     *            Senha
     * @return {@link Credenciais} preenchidas
     */
    private Credenciais getCredenciais(final String usuario, final String senha) {

        final CredenciaisBuilder<?> builder = service.getConector().getCredenciaisBuilder();

        if (builder instanceof CredenciaisSeleniumBuilder) {

            // Preenchimento específico para o conector selenium
            final CredenciaisSeleniumBuilder seleniumBuilder = (CredenciaisSeleniumBuilder) builder;
            seleniumBuilder.credenciais(usuario, senha);

        }

        return builder.build();

    }

}
