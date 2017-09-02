package br.edu.fatecsbc.sigapi.api.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.WebDriverException;

import br.edu.fatecsbc.sigapi.api.service.exception.ConectorException;
import br.edu.fatecsbc.sigapi.api.service.exception.SemResultadoException;
import br.edu.fatecsbc.sigapi.conector.Conector;
import br.edu.fatecsbc.sigapi.conector.dto.CalendarioProvas;
import br.edu.fatecsbc.sigapi.conector.dto.Credenciais;
import br.edu.fatecsbc.sigapi.conector.dto.DadosCadastrais;
import br.edu.fatecsbc.sigapi.conector.dto.DadosDesempenho;
import br.edu.fatecsbc.sigapi.conector.dto.FaltasParciais;
import br.edu.fatecsbc.sigapi.conector.dto.Historico;
import br.edu.fatecsbc.sigapi.conector.dto.NotasParciais;

@Service
public class ConectorService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Collection<Conector<? extends Credenciais>> conectores;

    @SuppressWarnings("unchecked")
    public Conector<Credenciais> getConector() {

        if (conectores == null || conectores.isEmpty()) {
            throw new IllegalStateException("Nenhum conector definido");
        }

        return (Conector<Credenciais>) conectores.iterator().next();

    }

    @Cacheable(value = "dados-cadastrais", unless = "#result == null")
    public DadosCadastrais getDadosCadastrais(final Credenciais credenciais) {

        logger.info("Obtendo dados cadastrais");

        try {

            final DadosCadastrais result = getConector().getDadosCadastrais(credenciais);

            if (result == null) {
                throw new SemResultadoException();
            }

            return result;

        } catch (final WebDriverException e) {
            throw new ConectorException(e);
        }

    }

    @Cacheable(value = "dados-desempenho", unless = "#result == null")
    public DadosDesempenho getDadosDesempenho(final Credenciais credenciais) {

        logger.info("Obtendo dados de desempenho");

        try {

            final DadosDesempenho result = getConector().getDadosDesempenho(credenciais);

            if (result == null) {
                throw new SemResultadoException();
            }

            return result;

        } catch (final WebDriverException e) {
            throw new ConectorException(e);
        }

    }

    @Cacheable(value = "historico", unless = "#result == null")
    public Historico getHistorico(final Credenciais credenciais) {

        logger.info("Obtendo histórico");

        try {

            final Historico result = getConector().getHistorico(credenciais);

            if (result == null) {
                throw new SemResultadoException();
            }

            return result;

        } catch (final WebDriverException e) {
            throw new ConectorException(e);
        }

    }

    @Cacheable(value = "notas-parciais", unless = "#result == null")
    public NotasParciais getNotasParciais(final Credenciais credenciais) {

        logger.info("Obtendo notas parciais");

        try {

            final NotasParciais result = getConector().getNotasParciais(credenciais);

            if (result == null) {
                throw new SemResultadoException();
            }

            return result;

        } catch (final WebDriverException e) {
            throw new ConectorException(e);
        }

    }

    @Cacheable(value = "faltas-parciais", unless = "#result == null")
    public FaltasParciais getFaltasParciais(final Credenciais credenciais) {

        logger.info("Obtendo faltas parciais");

        try {

            final FaltasParciais result = getConector().getFaltasParciais(credenciais);

            if (result == null) {
                throw new SemResultadoException();
            }

            return result;

        } catch (final WebDriverException e) {
            throw new ConectorException(e);
        }
    }

    @Cacheable(value = "calendario-provas", unless = "#result == null")
    public CalendarioProvas getCalendarioProvas(final Credenciais credenciais) {

        logger.info("Obtendo calendário de provas");

        try {

            final CalendarioProvas result = getConector().getCalendarioProvas(credenciais);

            if (result == null) {
                throw new SemResultadoException();
            }

            return result;

        } catch (final WebDriverException e) {
            throw new ConectorException(e);
        }
    }

}