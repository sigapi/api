package br.edu.fatecsbc.sigapi.api.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.lang3.StringUtils;

import br.edu.fatecsbc.sigapi.api.dto.response.FaltaParcialResponse;
import br.edu.fatecsbc.sigapi.api.service.exception.SemResultadoException;
import br.edu.fatecsbc.sigapi.api.util.function.FaltasParciaisToFaltaParcialResponseCollection;
import br.edu.fatecsbc.sigapi.api.util.function.RegistroFaltaParcialToFaltaParcialResponse;
import br.edu.fatecsbc.sigapi.conector.dto.FaltasParciais;
import br.edu.fatecsbc.sigapi.conector.dto.RegistroFaltaParcial;

@RestController
public class FaltasParciaisController // NO_UCD (unused code)
    extends AbstractController {

    @RequestMapping(value = "/faltas-parciais", method = RequestMethod.GET)
    public Collection<FaltaParcialResponse> get() {

        final FaltasParciais faltasParciais = service.getFaltasParciais(getCredenciais());
        return new FaltasParciaisToFaltaParcialResponseCollection().apply(faltasParciais);

    }

    @RequestMapping(value = "/faltas-parciais/{sigla}", method = RequestMethod.GET)
    public FaltaParcialResponse get(@PathVariable final String sigla) {

        final FaltasParciais faltasParciais = service.getFaltasParciais(getCredenciais());
        final Collection<RegistroFaltaParcial> registros = faltasParciais.getRegistros();

        if (registros != null) {
            final Optional<RegistroFaltaParcial> optional = registros.stream()
                .filter(r -> StringUtils.equalsIgnoreCase(sigla, r.getDisciplina().getSigla())).findFirst();

            if (optional.isPresent()) {
                return new RegistroFaltaParcialToFaltaParcialResponse().apply(optional.get());
            }
        }

        throw new SemResultadoException();

    }

}
