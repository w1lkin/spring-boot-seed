package com.welkin.springbootseed.mbg.plugins;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.codegen.RootClassInfo;
import org.mybatis.generator.codegen.mybatis3.model.BaseRecordGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.mybatis.generator.internal.util.JavaBeansUtil.*;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

public class CustomerRecordGenerator extends BaseRecordGenerator {

  public CustomerRecordGenerator() {
    super();
  }

  @Override
  public List<CompilationUnit> getCompilationUnits() {
    FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();
    progressCallback.startTask(getString("Progress.8", table.toString())); // $NON-NLS-1$
    Plugin plugins = context.getPlugins();
    CommentGenerator commentGenerator = context.getCommentGenerator();

    FullyQualifiedJavaType type = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
    TopLevelClass topLevelClass = new TopLevelClass(type);
    topLevelClass.setVisibility(JavaVisibility.PUBLIC);
    commentGenerator.addJavaFileComment(topLevelClass);

    FullyQualifiedJavaType superClass = getSuperClass();
    if (superClass != null) {
      topLevelClass.setSuperClass(superClass);
      topLevelClass.addImportedType(superClass);
    }
    commentGenerator.addModelClassComment(topLevelClass, introspectedTable);

    List<IntrospectedColumn> introspectedColumns = getColumnsInThisClass();

    if (introspectedTable.isConstructorBased()) {
      addParameterizedConstructor(topLevelClass);

      if (!introspectedTable.isImmutable()) {
        addDefaultConstructor(topLevelClass);
      }
    }

    String rootClass = getRootClass();
    for (IntrospectedColumn introspectedColumn : introspectedColumns) {
      if (RootClassInfo.getInstance(rootClass, warnings).containsProperty(introspectedColumn)) {
        continue;
      }

      Field field = getJavaBeansField(introspectedColumn, context, introspectedTable);
      if (plugins.modelFieldGenerated(
          field,
          topLevelClass,
          introspectedColumn,
          introspectedTable,
          Plugin.ModelClassType.BASE_RECORD)) {
        topLevelClass.addField(field);
        topLevelClass.addImportedType(field.getType());
      }

      Method method = getJavaBeansGetter(introspectedColumn, context, introspectedTable);
      if (plugins.modelGetterMethodGenerated(
          method,
          topLevelClass,
          introspectedColumn,
          introspectedTable,
          Plugin.ModelClassType.BASE_RECORD)) {
        topLevelClass.addMethod(method);
      }

      if (!introspectedTable.isImmutable()) {
        method = getJavaBeansSetter(introspectedColumn, context, introspectedTable);
        if (plugins.modelSetterMethodGenerated(
            method,
            topLevelClass,
            introspectedColumn,
            introspectedTable,
            Plugin.ModelClassType.BASE_RECORD)) {
          topLevelClass.addMethod(method);
        }
      }
    }

    List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
    if (context.getPlugins().modelBaseRecordClassGenerated(topLevelClass, introspectedTable)) {
      answer.add(topLevelClass);
    }
    return answer;
  }

  private FullyQualifiedJavaType getSuperClass() {
    FullyQualifiedJavaType superClass;
    if (introspectedTable.getRules().generatePrimaryKeyClass()) {
      superClass = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
    } else {
      String rootClass = getRootClass();
      if (rootClass != null) {
        superClass = new FullyQualifiedJavaType(rootClass);
      } else {
        superClass = null;
      }
    }

    return superClass;
  }

  private boolean includePrimaryKeyColumns() {
    return !introspectedTable.getRules().generatePrimaryKeyClass()
        && introspectedTable.hasPrimaryKeyColumns();
  }

  private boolean includeBLOBColumns() {
    return !introspectedTable.getRules().generateRecordWithBLOBsClass()
        && introspectedTable.hasBLOBColumns();
  }

  private void addParameterizedConstructor(TopLevelClass topLevelClass) {
    Method method = new Method();
    method.setVisibility(JavaVisibility.PUBLIC);
    method.setConstructor(true);
    method.setName(topLevelClass.getType().getShortName());
    context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);

    List<IntrospectedColumn> constructorColumns =
        includeBLOBColumns()
            ? introspectedTable.getAllColumns()
            : introspectedTable.getNonBLOBColumns();

    for (IntrospectedColumn introspectedColumn : constructorColumns) {
      method.addParameter(
          new Parameter(
              introspectedColumn.getFullyQualifiedJavaType(),
              introspectedColumn.getJavaProperty()));
      topLevelClass.addImportedType(introspectedColumn.getFullyQualifiedJavaType());
    }

    StringBuilder sb = new StringBuilder();
    if (introspectedTable.getRules().generatePrimaryKeyClass()) {
      boolean comma = false;
      sb.append("super("); // $NON-NLS-1$
      for (IntrospectedColumn introspectedColumn : introspectedTable.getPrimaryKeyColumns()) {
        if (comma) {
          sb.append(", "); // $NON-NLS-1$
        } else {
          comma = true;
        }
        sb.append(introspectedColumn.getJavaProperty());
      }
      sb.append(");"); // $NON-NLS-1$
      method.addBodyLine(sb.toString());
    }

    List<IntrospectedColumn> introspectedColumns = getColumnsInThisClass();

    for (IntrospectedColumn introspectedColumn : introspectedColumns) {
      sb.setLength(0);
      sb.append("this."); // $NON-NLS-1$
      sb.append(introspectedColumn.getJavaProperty());
      sb.append(" = "); // $NON-NLS-1$
      sb.append(introspectedColumn.getJavaProperty());
      sb.append(';');
      method.addBodyLine(sb.toString());
    }

    topLevelClass.addMethod(method);
  }

  List<String> commonFiledName =
      Arrays.asList(
          "owner_id",
          "delete_userid",
          "update_userid",
          "create_userid",
          "sys_time",
          "update_time",
          "create_time",
          "delete_time",
          "is_deleted");

  private List<IntrospectedColumn> getColumnsInThisClass() {
    List<IntrospectedColumn> introspectedColumns;
    if (includePrimaryKeyColumns()) {
      if (includeBLOBColumns()) {
        introspectedColumns = introspectedTable.getAllColumns();
      } else {
        introspectedColumns = introspectedTable.getNonBLOBColumns();
      }
    } else {
      if (includeBLOBColumns()) {
        introspectedColumns = introspectedTable.getNonPrimaryKeyColumns();
      } else {
        introspectedColumns = introspectedTable.getBaseColumns();
      }
    }

    // 去除公共字段
    for (Iterator<IntrospectedColumn> iter = introspectedColumns.iterator(); iter.hasNext(); ) {

      IntrospectedColumn column = iter.next();

      if (commonFiledName.contains(column.getActualColumnName())) {
        iter.remove();
      }
    }

    return introspectedColumns;
  }
}
