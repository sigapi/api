package br.edu.fatecsbc.sigapi.api.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.fatecsbc.sigapi.api.service.CacheService;
import br.edu.fatecsbc.sigapi.api.service.CredenciaisService;

@Component("cache-interceptor")
public class CacheInterceptor // NO_UCD (unused code)
    implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CacheService service;

    @Autowired
    private CredenciaisService credenciaisService;

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
        throws Exception {

        logger.debug("Executando");
        return true;

    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
        final ModelAndView modelAndView) throws Exception {

        logger.debug("Executando");

    }

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
        final Object handler, final Exception ex) throws Exception {

        logger.debug("Inicializando");
        service.atualizarDados(credenciaisService.getCredenciais());
        logger.debug("Finalizando");

    }

}