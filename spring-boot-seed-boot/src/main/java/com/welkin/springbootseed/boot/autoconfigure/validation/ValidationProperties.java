package com.welkin.springbootseed.boot.autoconfigure.validation;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Validation Properties
 *
 * @author welkin
 * @version 2.0.0
 */
@ConfigurationProperties(prefix = ValidationProperties.VALIDATION_PREFIX)
public class ValidationProperties {

  public static final String VALIDATION_PREFIX = "validation";

  private String mappingLocation;

  public String getMappingLocation() {
    return mappingLocation;
  }

  public void setMappingLocation(String mappingLocation) {
    this.mappingLocation = mappingLocation;
  }
}
