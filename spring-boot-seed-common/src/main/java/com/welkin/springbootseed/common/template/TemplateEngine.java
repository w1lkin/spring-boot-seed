package com.welkin.springbootseed.common.template;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 *  模版引擎
 *
 * @author Gavin Hu
 * @version 2.0.0
 */
public interface TemplateEngine {

    void process(String name, Map context, OutputStream output) throws IOException;

}
