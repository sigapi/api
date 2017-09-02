package br.edu.fatecsbc.sigapi.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.edu.fatecsbc.sigapi.conector.selenium.ConectorSeleniumConfig;

@Configuration
@Import({ ConectorSeleniumConfig.class })
@EnableAsync
@EnableCaching
public class WebConfig // NO_UCD (unused code)
    extends WebMvcConfigurerAdapter {

    @Autowired
    @Qualifier("cache-interceptor")
    private HandlerInterceptor interceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/api/**");
    }
}