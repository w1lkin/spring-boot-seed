package com.welkin.springbootseed.common.template.jxls;

import com.welkin.springbootseed.common.template.TemplateEngine;
import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于 Jxls 的模板引擎实现
 *
 * @author welkin
 */
public class JxlsTemplateEngine implements TemplateEngine, ResourceLoaderAware, InitializingBean {

  private static final String DEFAULT_TEMPLATE_PATH = "classpath*:/templates/jxls/defaulttheme/**/*.xlsx";

  private ResourceLoader resourceLoader;

  private String templatePath = DEFAULT_TEMPLATE_PATH;

  private Map<String, Resource> templateResourceMap = new LinkedHashMap<>();

  private Map<String, Object> customFunctions = new LinkedHashMap<>();

  @Override
  public void process(String name, Map context, OutputStream output) throws IOException {
    JxlsHelper jxlsHelper = JxlsHelper.getInstance();
    Resource templateResource = templateResourceMap.get(name);
    Transformer transformer =
        jxlsHelper.createTransformer(templateResource.getInputStream(), output);
    JexlExpressionEvaluator expressionEvaluator =
        (JexlExpressionEvaluator) transformer.getTransformationConfig().getExpressionEvaluator();
    expressionEvaluator.getJexlEngine().setFunctions(customFunctions);
    //
    jxlsHelper.processTemplate(new Context(context), transformer);
  }

  @Override
  public void setResourceLoader(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }

  public void setTemplatePath(String templatePath) {
    this.templatePath = templatePath;
  }

  public void setCustomFunctions(Map<String, Object> customFunctions) {
    this.customFunctions = customFunctions;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    ResourcePatternResolver resourcePatternResolver =
        ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
    Resource[] templateResources = resourcePatternResolver.getResources(templatePath);
    for (Resource templateResource : templateResources) {
      //
      String templateName = StringUtils.split(templateResource.getFilename(), ".")[0];
      templateResourceMap.put(templateName, templateResource);
    }
  }
}
