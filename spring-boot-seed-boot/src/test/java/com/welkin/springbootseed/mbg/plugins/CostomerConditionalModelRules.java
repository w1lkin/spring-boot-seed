package com.welkin.springbootseed.mbg.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.internal.rules.ConditionalModelRules;

/**
 * @author liuxy
 * @Date 2017/4/21
 */
public class CostomerConditionalModelRules extends ConditionalModelRules {


    /**
     * Instantiates a new conditional model rules.
     *
     * @param introspectedTable the introspected table
     */
    public CostomerConditionalModelRules(IntrospectedTable introspectedTable) {
        super(introspectedTable);
    }

}
