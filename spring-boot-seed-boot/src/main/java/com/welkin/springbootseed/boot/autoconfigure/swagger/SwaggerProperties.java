package com.welkin.springbootseed.boot.autoconfigure.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * SwaggerProperties
 *
 * @author welkin
 * @version 2.0.0
 */
@ConfigurationProperties(prefix = SwaggerProperties.SWAGGER_PREFIX)
public class SwaggerProperties {

  public static final String SWAGGER_PREFIX = "swagger";

  private String basePath;

  private String title;
  private String description;
  private String contact;
  private String license;
  private String licenseUrl;
  private String termsOfServiceUrl;
  private String filterClass;

  private String resourcePackage;

  public String getResourcePackage() {
    return resourcePackage;
  }

  public void setResourcePackage(String resourcePackage) {
    this.resourcePackage = resourcePackage;
  }

  public String getBasePath() {
    return basePath;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public String getLicenseUrl() {
    return licenseUrl;
  }

  public void setLicenseUrl(String licenseUrl) {
    this.licenseUrl = licenseUrl;
  }

  public String getTermsOfServiceUrl() {
    return termsOfServiceUrl;
  }

  public void setTermsOfServiceUrl(String termsOfServiceUrl) {
    this.termsOfServiceUrl = termsOfServiceUrl;
  }

  public String getFilterClass() {
    return filterClass;
  }

  public void setFilterClass(String filterClass) {
    this.filterClass = filterClass;
  }
}
