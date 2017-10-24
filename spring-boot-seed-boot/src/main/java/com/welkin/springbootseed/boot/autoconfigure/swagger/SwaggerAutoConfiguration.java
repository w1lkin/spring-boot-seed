package com.welkin.springbootseed.boot.autoconfigure.swagger;

import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyDescriptor;

/**
 * SwaggerAutoConfiguration
 *
 * @author Gavin Hu
 * @version 2.0.0
 */
@Configuration
@ConditionalOnClass({Swagger2Feature.class})
@ConditionalOnProperty(name = "swagger.enabled")
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerAutoConfiguration {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    @ConditionalOnMissingBean
    public Swagger2Feature swagger2Feature() {
        BeanWrapper swagger2FeatureWrapper = new BeanWrapperImpl(Swagger2Feature.class);
        BeanWrapper swaggerPropertiesWrapper = new BeanWrapperImpl(swaggerProperties);
        //
        for(PropertyDescriptor pd : swaggerPropertiesWrapper.getPropertyDescriptors()) {
            if(swagger2FeatureWrapper.isWritableProperty(pd.getName())) {
                Object value = swaggerPropertiesWrapper.getPropertyValue(pd.getName());
                swagger2FeatureWrapper.setPropertyValue(pd.getName(), value);
            }
        }
        //
        return (Swagger2Feature) swagger2FeatureWrapper.getWrappedInstance();
    }

}
