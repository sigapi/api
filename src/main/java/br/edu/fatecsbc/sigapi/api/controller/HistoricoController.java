package br.edu.fatecsbc.sigapi.api.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecsbc.sigapi.api.dto.response.HistoricoResponse;
import br.edu.fatecsbc.sigapi.api.service.exception.NaoImplementadoException;

@RestController
public class HistoricoController // NO_UCD (unused code)
    extends AbstractController {

    @RequestMapping(value = "/historico", method = RequestMethod.GET)
    public Collection<HistoricoResponse> get() {
        throw new NaoImplementadoException();
    }

}
