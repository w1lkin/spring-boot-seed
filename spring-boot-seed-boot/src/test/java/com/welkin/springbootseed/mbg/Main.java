package com.welkin.springbootseed.mbg;

import com.welkin.springbootseed.mbg.bridge.MybatisGeneratorBridge;
import com.welkin.springbootseed.mbg.model.DatabaseConfig;
import com.welkin.springbootseed.mbg.model.GeneratorConfig;
import com.welkin.springbootseed.mbg.model.Table;

import java.util.ArrayList;
import java.util.List;

/** @author welkin mybatis genertor */
public class Main {

  public static void main(String[] args) throws Exception {
    GeneratorConfig generatorConfig =
        new GeneratorConfig(
            "C:\\Program\\mbg\\mysql-connector-java-5.1.38.jar",
            "C:\\Program\\mbg",
            "com.welkin.springbootseed.model.order",
            "src\\main\\java",
            "com.welkin.springbootseed.dao.order",
            "src\\main\\java",
            "com.welkin.springbootseed.dao.order",
            "src\\main\\resources");
    //
    DatabaseConfig databaseConfig =
        new DatabaseConfig(
            "jdbc:mysql://dev.mysql.apitops.com:4308/tops_finance?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull",
            "finance_dev",
            "mFpUowzjKJFfw53qStUx9WUNJWZPh2");
    //
    List<Table> list = new ArrayList<>();
    list.add(new Table("tfs_risk_person_info_history", "RiskPersonInfoHistory"));
    // list.add(new Table("fin_factoring_detail", "FactoringDetail"));

    //
    MybatisGeneratorBridge bridge =
        new MybatisGeneratorBridge(generatorConfig, databaseConfig, list);
    bridge.generator();
  }
}
