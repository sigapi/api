package br.edu.fatecsbc.sigapi.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecsbc.sigapi.api.dto.response.DadosDesempenhoResponse;
import br.edu.fatecsbc.sigapi.api.util.function.DadosDesempenhoToDadosDesempenhoResponse;
import br.edu.fatecsbc.sigapi.conector.dto.DadosDesempenho;

@RestController
public class DadosDesempenhoController // NO_UCD (unused code)
    extends AbstractController {

    @RequestMapping(value = "/dados-desempenho", method = RequestMethod.GET)
    public DadosDesempenhoResponse get() {

        final DadosDesempenho dadosDesempenho = service.getDadosDesempenho(getCredenciais());
        return new DadosDesempenhoToDadosDesempenhoResponse().apply(dadosDesempenho);

    }

}
