package com.algaworks.algafoodapi.core.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {

    /*
     * Isso foi criado apenas para mostrar uma forma de resolver validações do javax
     * Não é necessário, uma vez que o Spring já possui um mecanismo para resolver
     * mensagens de validação.
     */
    @Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }
}
