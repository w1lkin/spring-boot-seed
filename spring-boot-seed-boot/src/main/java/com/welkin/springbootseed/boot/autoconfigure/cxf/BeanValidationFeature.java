package com.welkin.springbootseed.boot.autoconfigure.cxf;

import org.apache.cxf.annotations.Provider;

/**
 * Bean Validation Feature
 *
 * @author Gavin Hu
 * @version 2.0.0
 */
@Provider(value = Provider.Type.Feature, scope = Provider.Scope.Server)
public class BeanValidationFeature extends org.apache.cxf.validation.BeanValidationFeature {
}
