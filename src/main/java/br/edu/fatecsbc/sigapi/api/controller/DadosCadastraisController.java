package br.edu.fatecsbc.sigapi.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecsbc.sigapi.api.dto.response.DadosCadastraisResponse;
import br.edu.fatecsbc.sigapi.api.util.function.DadosCadastraisToDadosCadastraisResponse;
import br.edu.fatecsbc.sigapi.conector.dto.DadosCadastrais;

@RestController
public class DadosCadastraisController // NO_UCD (unused code)
    extends AbstractController {

    @RequestMapping(value = "/dados-cadastrais", method = RequestMethod.GET)
    public DadosCadastraisResponse get() {

        final DadosCadastrais dadosCadastrais = service.getDadosCadastrais(getCredenciais());
        return new DadosCadastraisToDadosCadastraisResponse().apply(dadosCadastrais);

    }

}
