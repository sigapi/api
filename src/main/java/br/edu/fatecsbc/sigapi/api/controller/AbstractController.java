package br.edu.fatecsbc.sigapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.fatecsbc.sigapi.api.service.ConectorService;
import br.edu.fatecsbc.sigapi.api.service.CredenciaisService;
import br.edu.fatecsbc.sigapi.conector.dto.Credenciais;

@RequestMapping("/api")
abstract class AbstractController {

    @Autowired
    protected ConectorService service;

    @Autowired
    private CredenciaisService credenciaisService;

    protected Credenciais getCredenciais() {
        return credenciaisService.getCredenciais();
    }
}
