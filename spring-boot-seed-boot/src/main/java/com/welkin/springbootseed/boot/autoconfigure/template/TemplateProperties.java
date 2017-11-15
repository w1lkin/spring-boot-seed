package com.welkin.springbootseed.boot.autoconfigure.template;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Template Properties
 *
 * @author Gavin Hu
 * @version 2.2.2
 */
@ConfigurationProperties(prefix = TemplateProperties.TEMPLATE_PREFIX)
public class TemplateProperties {

    public static final String TEMPLATE_PREFIX = "template";

    private Boolean enabled;

    private String path;

    private Map<String, String> functionClasses = new HashMap<>();

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getFunctionClasses() {
        return functionClasses;
    }

    public void setFunctionClasses(Map<String, String> functionClasses) {
        this.functionClasses = functionClasses;
    }
}