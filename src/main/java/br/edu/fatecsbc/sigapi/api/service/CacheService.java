package br.edu.fatecsbc.sigapi.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.fatecsbc.sigapi.conector.dto.Credenciais;

@Service
public class CacheService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ConectorService service;

    @Async
    public void atualizarDados(final Credenciais credenciais) {

        logger.debug("Iniciando atualização");

        service.getDadosCadastrais(credenciais);
        service.getDadosDesempenho(credenciais);
        service.getNotasParciais(credenciais);
        service.getFaltasParciais(credenciais);

        logger.debug("Finalizando atualização");

    }

}
