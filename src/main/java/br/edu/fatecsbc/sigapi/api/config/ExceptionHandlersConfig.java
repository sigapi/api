package br.edu.fatecsbc.sigapi.api.config;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.lang3.StringUtils;

import br.edu.fatecsbc.sigapi.api.dto.response.ErroResponse;
import br.edu.fatecsbc.sigapi.api.service.exception.ConectorException;
import br.edu.fatecsbc.sigapi.api.service.exception.NaoImplementadoException;
import br.edu.fatecsbc.sigapi.api.service.exception.SemResultadoException;

@ControllerAdvice
public class ExceptionHandlersConfig { // NO_UCD (unused code)

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlersConfig.class);

    @ExceptionHandler(SemResultadoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErroResponse handle(final SemResultadoException e) {

        return new ErroResponse("Sem resultado");

    }

    @ExceptionHandler(NaoImplementadoException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ResponseBody
    public ErroResponse handle(final NaoImplementadoException e) {
        return new ErroResponse("Método não implementado");
    }

    @ExceptionHandler(ConectorException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    @ResponseBody
    public ErroResponse handle(final ConectorException e) {

        log.error("ConectorException", e);
        return new ErroResponse("Não foi possível conectar ao SIGA nesse momento");

    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    @ResponseBody
    public ErroResponse handle(final IOException e) {

        log.error("IOException", e);
        return new ErroResponse("Não foi possível conectar ao SIGA nesse momento");

    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErroResponse handle(final AccessDeniedException e) {

        log.error("AccessDeniedException", e);
        return new ErroResponse("Acesso negado");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErroResponse handle(final Exception e) {

        log.error("Exception", e);
        final String message = StringUtils.defaultIfBlank(e.getMessage(), "Erro inesperado").trim();
        return new ErroResponse(message);

    }

}