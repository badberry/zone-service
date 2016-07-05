Zone Service(区域信息服务)
===================
提供地区服务，包括国家，省，城市，区/县的数据服务
### Function
1. 使用Swagger提供接口文档的生成.
2. 使用[Rest-Assured](https://github.com/jayway/rest-assured)测试Rest Api,集成在spring-boot-test里面.
3. 提供统一的错误处理，重写spring-boot的basicerrorcontroller,代替为UnitedErrorController.还有些功能待丰富.

## Future
1. 抽取访问日志
2. 抽取基础依赖（接口文档，测试实现）
3. 服务注册功能实现并抽取
4. 错误处理抽取成公共功能
5. 集中化日志实现
6. 自动打包docker image
7. 监控实现，并抽象出封装实现
