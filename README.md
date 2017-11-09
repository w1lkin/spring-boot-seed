# spring-boot-seed

> 该项目目的是学习spring-boot, 积累技术。

### 更新日志
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
![java web开发技术栈](https://thumbnail10.baidupcs.com/thumbnail/89432964c5aa452d4ef59af9c0e36379?fid=3440443774-250528-1103019712154757&time=1510196400&rt=sh&sign=FDTAER-DCb740ccc5511e5e8fedcff06b081203-czzwzSDvcI1v7g08pk8uGLBODsg%3D&expires=8h&chkv=0&chkbd=0&chkpc=&dp-logid=7247576729958913066&dp-callid=0&size=c1536_u864&quality=90&vuk=-&ft=video)

### 项目结构说明
> 参考三层架构
- spring-boot-seed-boot spring-boot启动层
- spring-boot-seed-common 通用组件层
- spring-boot-seed-dao 数据访问层
- spring-boot-seed-model 模型层
- spring-boot-seed-service 业务逻辑层
- spring-boot-seed-task 定时任务层
- spring-boot-seed-web 表现层, 对外提供rest接口
