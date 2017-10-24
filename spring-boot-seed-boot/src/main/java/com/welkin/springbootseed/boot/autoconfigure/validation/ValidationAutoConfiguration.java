package com.welkin.springbootseed.boot.autoconfigure.validation;

import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Valid;
import javax.validation.ValidatorFactory;
import java.io.IOException;

/**
 * Validation Auto Configuration
 *
 * @author Gavin Hu
 * @version 2.0.0
 */
@Configuration
@ConditionalOnClass(Valid.class)
@EnableConfigurationProperties(ValidationProperties.class)
public class ValidationAutoConfiguration {

    @Autowired
    private ValidationProperties validationProperties;

    @Bean
    @ConditionalOnMissingBean(MethodValidationPostProcessor.class)
    public MethodValidationPostProcessor methodValidationPostProcessor(ValidatorFactory validatorFactory) {
        MethodValidationPostProcessor methodValidationPostProcessor = new MethodValidationPostProcessor();
        methodValidationPostProcessor.setValidatorFactory(validatorFactory);
        //
        return methodValidationPostProcessor;
    }

    @Bean
    @ConditionalOnMissingBean(LocalValidatorFactoryBean.class)
    public LocalValidatorFactoryBean localValidatorFactoryBean(ApplicationContext applicationContext) {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
        if(validationProperties.getMappingLocation()!=null) {
            try {
                Resource[] mappingResources = applicationContext.getResources(validationProperties.getMappingLocation());
                localValidatorFactoryBean.setMappingLocations(mappingResources);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //
        return localValidatorFactoryBean;
    }

}
