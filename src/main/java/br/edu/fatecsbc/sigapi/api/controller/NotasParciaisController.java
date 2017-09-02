package br.edu.fatecsbc.sigapi.api.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.lang3.StringUtils;

import br.edu.fatecsbc.sigapi.api.dto.response.NotaParcialResponse;
import br.edu.fatecsbc.sigapi.api.service.exception.SemResultadoException;
import br.edu.fatecsbc.sigapi.api.util.function.NotasParciaisToNotaParcialResponseCollection;
import br.edu.fatecsbc.sigapi.api.util.function.RegistroNotaParcialToNotaParcialResponse;
import br.edu.fatecsbc.sigapi.conector.dto.NotasParciais;
import br.edu.fatecsbc.sigapi.conector.dto.RegistroNotaParcial;

@RestController
public class NotasParciaisController // NO_UCD (unused code)
    extends AbstractController {

    @RequestMapping(value = "/notas-parciais", method = RequestMethod.GET)
    public Collection<NotaParcialResponse> get() {

        final NotasParciais notasParciais = service.getNotasParciais(getCredenciais());
        return new NotasParciaisToNotaParcialResponseCollection().apply(notasParciais);

    }

    @RequestMapping(value = "/notas-parciais/{sigla}", method = RequestMethod.GET)
    public NotaParcialResponse get(@PathVariable final String sigla) {

        final NotasParciais notasParciais = service.getNotasParciais(getCredenciais());
        final Collection<RegistroNotaParcial> registros = notasParciais.getRegistros();

        if (registros != null) {
            final Optional<RegistroNotaParcial> optional = registros.stream()
                .filter(r -> StringUtils.equalsIgnoreCase(sigla, r.getDisciplina().getSigla())).findFirst();

            if (optional.isPresent()) {
                return new RegistroNotaParcialToNotaParcialResponse().apply(optional.get());
            }
        }

        throw new SemResultadoException();

    }

}
