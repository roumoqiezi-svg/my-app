

## 项目说明: 

> 学习 springboot 中的代码分层管理


## 项目结构:

```
activity-service
│  pom.xml ← 依赖 user-service-api
│
├─src
|   └─main
|       ├─java
        │  └─com
        │      └─example
        │          └─activity
        │              │  ActivityApplication.java ← 启动类
        │              │
        │              ├─application  ← 应用层（协调 domain + infra）
        │              │  │  ActivityService.java
        │              │  │
        │              │  └─impl
        │              │          ActivityServiceImpl.java
        │              │
        │              ├─domain ← 领域层（核心业务逻辑，无框架依赖）
        │              │  ├─model
        │              │  │      Activity.java
        │              │  │
        │              │  ├─repository ← 重点看这里
        │              │  │      ActivityRepository.java
        │              │  │
        │              │  └─service
        │              │          ActivityDomainService.java
        │              │
        │              ├─infrastructure ← 基础设施层（技术细节）, 数据持久层 原则: 保证 entity 不出持久层
        │              │  ├─client ← 调用其他服务
        │              │  │  ├─service  ← 内部服务
        │              │  │  │  ├─order
        │              │  │  │  │      OrderApiClient.java
        │              │  │  │  │      OrderServiceClient.java ← 门面类
        │              │  │  │  │
        │              │  │  │  └─user
        │              │  │  │          UserApiClient.java
        │              │  │  │          UserServiceClient.java ← 门面类
        │              │  │  │
        │              │  │  └─thirdparty  ← 第三方外部服务
        │              │  │      └─alipay
        │              │  │          ├─auth
        │              │  │          │      AlipayAuthApiClient.java
        │              │  │          │      AlipayAuthRequest.java
        │              │  │          │      AlipayAuthResponse.java
        │              │  │          │      AlipayAuthServiceClient.java ← 门面类
        │              │  │          │
        │              │  │          └─trade
        │              │  │                  AlipayTradeApiClient.java
        │              │  │                  AlipayTradeRequest.java
        │              │  │                  AlipayTradeResponse.java
        │              │  │                  AlipayTradeServiceClient.java ← 门面类
        │              │  │
        │              │  ├─config  ← 数据库配置等等
        │              │  │      RedisConfig.java
        │              │  │
        │              │  └─persistence ← 数据库
        │              │      │  ActivityRepositoryImpl.java
        │              │      │
        │              │      ├─entity
        │              │      │      ActivityEntity.java
        │              │      │
        │              │      └─mapper
        │              │              ActivityMapper.java
        │              │
        │              └─interfaces  ← 对外接口层（适配各种入口）
        │                  ├─feign  ← Feign 接口实现（对接 user-service-api）
        │                  │      ActivityFeignProviderController.java
        │                  │
        │                  ├─job ← 这里假设有定时任务
        │                  │      SyncActivityJobController.java
        │                  │
        │                  └─web ← REST API（给前端 or 网关）
        │                      ├─aspect
        │                      │      .keep
        │                      │
        │                      ├─config
        │                      │      .keep
        │                      │
        │                      ├─controller
        │                      │      ActivityController.java
        │                      │
        │                      ├─dto
        │                      │      GetUserAndActivityInfoRequest.java
        │                      │      UserAndActivityInfoResponse.java
        │                      │
        │                      ├─exception
        │                      │      .keep
        │                      │
        │                      └─interceptor
        │                              .keep
        │
        └─resources
                application.yml
|
user-service 同activity-service
│  
│
├ ...
│
activity-service-api                                    ← 纯 Java 模块（无 Spring）
│  pom.xml                                              ← 只依赖 lombok
│
└─src
    └─main
        └─java
            └─com
                └─example
                    └─controller
                        ├─dto                           ← Feign 专用 DTO
                        │      GetActivityRequest.java
                        │      GetActivityResponse.java
                        │
                        └─feign
                                ActivityFeignApi.java   ← Feign 接口（无实现）

```

