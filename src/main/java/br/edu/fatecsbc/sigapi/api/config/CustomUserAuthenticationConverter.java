package br.edu.fatecsbc.sigapi.api.config;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

public class CustomUserAuthenticationConverter // NO_UCD (use default)
    extends DefaultUserAuthenticationConverter {

    private static final String ATRIBUTO_SENHA = "senha";
    private static final String ATRIBUTO_USUARIO = "usuario";

    @Override
    public Authentication extractAuthentication(final Map<String, ?> map) {

        final Authentication auth = super.extractAuthentication(map);

        if (auth != null && map.containsKey(ATRIBUTO_USUARIO) && map.containsKey(ATRIBUTO_SENHA)) {

            final String usuario = map.get(ATRIBUTO_USUARIO).toString();
            final String senha = map.get(ATRIBUTO_SENHA).toString();
            final Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

            final User user = new User(usuario, senha, authorities);
            return new UsernamePasswordAuthenticationToken(user, senha, authorities);

        }

        return null;

    }

}