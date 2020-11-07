# antass
以下为nacos配置：
### antass-personnel
yaml文件
```yaml
server:
  port: 8082

dubbo:
  protocol:
    name: dubbo
    port: -1
  registry:
    address: spring-cloud://localhost
  cloud:
    subscribed-services: antass-authorization

management:
  endpoints:
    web:
      exposure:
        include: "*"
```
### antass-authorization
yaml文件
```yaml
server:
  port: 8081

spring:
  cloud:
    sentinel:
      transport:
        dashboard: 127.0.0.1:8080
      datasource:
        ds1:
          nacos:
            server-addr: 127.0.0.1:8848
            dataId: antass-authorization-sentinel
            groupId: DEFAULT_GROUP
            data-type: json
            rule-type: flow

dubbo:
  scan:
    base-packages: com.sam.antass.authorization.service.dubbo
  protocol:
    name: dubbo
    port: -1
  registry:
    address: spring-cloud://localhost
  cloud:
    subscribed-services: ""

management:
  endpoints:
    web:
      exposure:
        include: "*"
```
### antass-authorization-sentinel
json文件
```json
[
    {
        "resource": "/antass/auth/user/{id}",
        "limitApp": "default",
        "grade": 1,
        "count": 1,
        "strategy": 0,
        "controlBehavior": 0,
        "clusterMode": false
    }
]
```
