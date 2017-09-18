package com.welkin.springbootseed.mbg.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.internal.rules.ConditionalModelRules;

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
