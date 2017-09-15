package com.welkin.springbootseed.mbg.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.sql.Types;
import java.util.List;

/**
 * @author liuxy
 * @Date 2017/4/21
 */
public class PKGeneratePlugin extends PluginAdapter {

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

        List<IntrospectedColumn> pks = introspectedTable.getPrimaryKeyColumns();
        if(pks != null && pks.size() > 1) {
            return true;
        }
        IntrospectedColumn introspectedColumn = pks.get(0);
        int jdbcType = introspectedColumn.getJdbcType();
        if(jdbcType != Types.BIGINT && jdbcType != Types.INTEGER) {
            return true;
        }
        element.addAttribute(new Attribute("useGeneratedKeys", "true"));
        element.addAttribute(new Attribute("keyProperty", introspectedColumn.getJavaProperty()));
        element.addAttribute(new Attribute("keyColumn", introspectedColumn.getActualColumnName()));

        return super.sqlMapInsertElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

        List<IntrospectedColumn> pks = introspectedTable.getPrimaryKeyColumns();
        if(pks != null && pks.size() > 1) {
            return true;
        }
        IntrospectedColumn introspectedColumn = pks.get(0);
        int jdbcType = introspectedColumn.getJdbcType();
        if(jdbcType != Types.BIGINT && jdbcType != Types.INTEGER) {
            return true;
        }
        element.addAttribute(new Attribute("useGeneratedKeys", "true"));
        element.addAttribute(new Attribute("keyProperty", introspectedColumn.getJavaProperty()));
        element.addAttribute(new Attribute("keyColumn", introspectedColumn.getActualColumnName()));

        return super.sqlMapInsertSelectiveElementGenerated(element, introspectedTable);
    }

    private void addPK(XmlElement element, IntrospectedTable introspectedTable) {

    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }
}
