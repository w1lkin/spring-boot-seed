# spring-boot-seed

> 该项目目的是学习spring-boot, 积累技术。

### 更新日志
- 2017年10月27日 集成mongodb,实现CRUD操作
- 2017年10月24日 集成swagger,hibernate-validator
- 2017年9月28日 集成pagehelper,实现分页
- 2017年9月26日 实现CRUD操作, 实现统一异常&出参处理
- 2017年9月18日 集成mybatis, mybatis-generator
- 2017年9月14日 基于spring-boot基础框架搭建, 集成cxf, jackson等

### 项目结构说明
> 参考三层架构
- spring-boot-seed-boot spring-boot启动层
- spring-boot-seed-common 通用组件层
- spring-boot-seed-dao 数据访问层
- spring-boot-seed-model 模型层
- spring-boot-seed-service 业务逻辑层
- spring-boot-seed-task 定时任务层
- spring-boot-seed-web 表现层,对外提供rest接口