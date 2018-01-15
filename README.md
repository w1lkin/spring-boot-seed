# spring-boot-seed

> 该项目目的是学习spring-boot, 积累技术。

### 更新日志
- 2018年1月15日 spring AOP学习
- 2018年1月11日 Jersey实现过滤器&拦截器，支持名称绑定和动态绑定
- 2017年11月16日 实现文件(包含excel,图片,txt)打包下载,导入excel模板
- 2017年11月15日 集成jxls,实现excel下载,支持自定义配置
- 2017年11月10日 集成oss,实现图片上传,私有图片地址获取
- 2017年11月9日 集成单元测试
- 2017年10月31日 集成redis,实现string相关操作
- 2017年10月30日 集成Elasticsearch, 实现CRUD操作
- 2017年10月27日 集成mongodb, 实现CRUD操作
- 2017年10月24日 集成swagger, hibernate-validator
- 2017年9月28日 集成pagehelper, 实现分页
- 2017年9月26日 实现CRUD操作, 实现统一异常&出参处理
- 2017年9月18日 集成mybatis, mybatis-generator
- 2017年9月14日 基础框架搭建(基于spring-boot), 集成cxf, jackson等

### 技术栈
![java web开发技术栈](https://raw.githubusercontent.com/w1lkin/img/master/spring-boot-seed/java-web%E5%BC%80%E5%8F%91%E6%8A%80%E6%9C%AF%E6%A0%88.png)

### 项目结构说明
> 参考三层架构
- spring-boot-seed-boot spring-boot启动层
- spring-boot-seed-common 通用组件层
- spring-boot-seed-dao 数据访问层
- spring-boot-seed-model 模型层
- spring-boot-seed-service 业务逻辑层
- spring-boot-seed-task 定时任务层
- spring-boot-seed-web 表现层, 对外提供rest接口
