package com.welkin.springbootseed.mbg.bridge;

import com.welkin.springbootseed.mbg.model.DatabaseConfig;
import com.welkin.springbootseed.mbg.model.GeneratorConfig;
import com.welkin.springbootseed.mbg.model.Table;
import com.welkin.springbootseed.mbg.plugins.DbRemarksCommentGenerator;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MybatisGeneratorBridge {

  private GeneratorConfig generatorConfig;

  private DatabaseConfig selectedDatabaseConfig;

  private List<Table> tables;

  public MybatisGeneratorBridge(
      GeneratorConfig generatorConfig, DatabaseConfig selectedDatabaseConfig, List<Table> tables) {
    this.generatorConfig = generatorConfig;
    this.selectedDatabaseConfig = selectedDatabaseConfig;
    this.tables = tables;

    createFile(
        generatorConfig.getModelPackageTargetFolder() + "/" + generatorConfig.getModelPackage());
    createFile(generatorConfig.getDaoTargetFolder() + "/" + generatorConfig.getDaoPackage());
    createFile(
        generatorConfig.getMappingXMLTargetFolder() + "/" + generatorConfig.getMappingXMLPackage());
  }

  private void createFile(String packageDir) {

    packageDir = packageDir.replace(".", "/");
    File modelPackage = new File(generatorConfig.getProjectFolder() + "/" + packageDir);
    if (!modelPackage.exists()) {
      modelPackage.mkdirs();
    }
  }

  public void generator() throws Exception {

    List<String> warnings = new ArrayList<>();
    Set<String> fullyqualifiedTables = new HashSet<>();
    Set<String> contexts = new HashSet<>();
    ShellCallback shellCallback = new DefaultShellCallback(true); // override=true
    Configuration config = new Configuration();
    config.addClasspathEntry(generatorConfig.getConnectorJarPath());

    for (Table table : tables) {

      Context context = context(table);
      config.addContext(context);
    }
    MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
    myBatisGenerator.generate(null, contexts, fullyqualifiedTables);
  }

  public Context context(Table table) {

    Context context = new Context(ModelType.CONDITIONAL);
    // Table config
    TableConfiguration tableConfig = new TableConfiguration(context);
    tableConfig.setTableName(table.getTableName());
    tableConfig.setDomainObjectName(table.getDomainObjectName());
    // tableConfig.setMapperName(generatorConfig.getDaoName());

    tableConfig.setCountByExampleStatementEnabled(false);
    tableConfig.setUpdateByExampleStatementEnabled(false);
    tableConfig.setDeleteByExampleStatementEnabled(false);
    tableConfig.setSelectByExampleStatementEnabled(false);
    tableConfig.setDeleteByPrimaryKeyStatementEnabled(false);

    JDBCConnectionConfiguration jdbcConfig = new JDBCConnectionConfiguration();
    jdbcConfig.setDriverClass("com.mysql.jdbc.Driver");
    jdbcConfig.setConnectionURL(selectedDatabaseConfig.getJdbcUrl());
    jdbcConfig.setUserId(selectedDatabaseConfig.getUsername());
    jdbcConfig.setPassword(selectedDatabaseConfig.getPassword());
    // java model
    JavaModelGeneratorConfiguration modelConfig = new JavaModelGeneratorConfiguration();
    modelConfig.setTargetPackage(generatorConfig.getModelPackage());
    modelConfig.setTargetProject(
        generatorConfig.getProjectFolder() + "\\" + generatorConfig.getModelPackageTargetFolder());
    modelConfig.addProperty(PropertyRegistry.ANY_ROOT_CLASS, "com.tops001.bops.model.Base");

    // Mapper config
    SqlMapGeneratorConfiguration mapperConfig = new SqlMapGeneratorConfiguration();
    mapperConfig.setTargetPackage(generatorConfig.getMappingXMLPackage());
    mapperConfig.setTargetProject(
        generatorConfig.getProjectFolder() + "\\" + generatorConfig.getMappingXMLTargetFolder());
    // DAO
    JavaClientGeneratorConfiguration daoConfig = new JavaClientGeneratorConfiguration();
    daoConfig.setConfigurationType("XMLMAPPER");
    daoConfig.setTargetPackage(generatorConfig.getDaoPackage());
    daoConfig.setTargetProject(
        generatorConfig.getProjectFolder() + "\\" + generatorConfig.getDaoTargetFolder());

    context.setId("myid");
    context.addTableConfiguration(tableConfig);
    context.setJdbcConnectionConfiguration(jdbcConfig);
    context.setJdbcConnectionConfiguration(jdbcConfig);
    context.setJavaModelGeneratorConfiguration(modelConfig);
    context.setSqlMapGeneratorConfiguration(mapperConfig);
    context.setJavaClientGeneratorConfiguration(daoConfig);
    // Comment
    CommentGeneratorConfiguration commentConfig = new CommentGeneratorConfiguration();
    commentConfig.setConfigurationType(DbRemarksCommentGenerator.class.getName());
    commentConfig.addProperty("columnRemarks", "true");
    context.setCommentGeneratorConfiguration(commentConfig);

    // 实体添加序列化
    PluginConfiguration serializablePluginConfiguration = new PluginConfiguration();
    serializablePluginConfiguration.addProperty(
        "type", "org.mybatis.generator.plugins.SerializablePlugin");
    serializablePluginConfiguration.setConfigurationType(
        "org.mybatis.generator.plugins.SerializablePlugin");
    context.addPluginConfiguration(serializablePluginConfiguration);

    // pk 自动返回
    PluginConfiguration pkPluginConfiguration = new PluginConfiguration();
    pkPluginConfiguration.addProperty(
        "type", "com.welkin.springbootseed.mbg.plugins.PKGeneratePlugin");
    pkPluginConfiguration.setConfigurationType(
        "com.welkin.springbootseed.mbg.plugins.PKGeneratePlugin");
    context.addPluginConfiguration(pkPluginConfiguration);

    context.setTargetRuntime("com.welkin.springbootseed.mbg.plugins.CustomerIntrospectedTable");

    return context;
  }
}
