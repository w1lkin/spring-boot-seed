package com.welkin.springbootseed.boot.autoconfigure.template;

import com.welkin.springbootseed.common.template.TemplateEngine;
import com.welkin.springbootseed.common.template.jxls.JxlsTemplateEngine;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Template Auto Configuration
 *
 * @author welkin
 */
@Configuration
@ConditionalOnClass(TemplateEngine.class)
@ConditionalOnProperty(name = "template.enabled")
@EnableConfigurationProperties(TemplateProperties.class)
public class TemplateAutoConfiguration {

  private static final ClassLoader defaultClassLoader = ClassUtils.getDefaultClassLoader();

  @Autowired private TemplateProperties templateProperties;

  @Bean("jxlsTemplateEngine")
  public TemplateEngine jxlsTemplateEngine() throws Exception {
    JxlsTemplateEngine templateEngine = new JxlsTemplateEngine();
    if (StringUtils.hasText(templateProperties.getPath())) {
      templateEngine.setTemplatePath(templateProperties.getPath());
    }
    //
    Map<String, Object> functionObjects = new HashMap<>();
    Map<String, String> functionClasses = templateProperties.getFunctionClasses();
    for (String functionName : functionClasses.keySet()) {
      String functionClass = functionClasses.get(functionName);
      Object functionObject =
          BeanUtils.instantiate(ClassUtils.forName(functionClass, defaultClassLoader));
      functionObjects.put(functionName, functionObject);
    }
    templateEngine.setCustomFunctions(functionObjects);
    //
    return templateEngine;
  }
}
