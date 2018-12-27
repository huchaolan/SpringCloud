# Eureka

Spring Eureka基于Netflix Eureka做二次封装，由服务端和客户端组成。客户端用来简化与服务端的交互，作为轮询负载均衡器提供了服务故障的切换。服务端是服务注册中心

## 注册中心(Eureka Server)

注册中心提供服务的注册和发现。

### 创建Eureka服务端项目

+ 使用[Spring官网的构件工具](https://start.spring.io/),创建EurekaServer的Maven项目。按照下图输入，然后再点击GenerateProject就可以生成好了![项目配置图片](imgs/springeuraka1.png)

+ 网站默认生成了一些代码，这个启动是有问题，需要加上```@EnableEurekaServer```才能启动eureka，启动后Eureka默认会找服务端，在日志还是会有些报错。打开[Eureka](http://127.0.0.1:8761/)页面显示注册相关信息

```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
```

+ 使用yml的配置文件，eclipse需要按照插件才可以编辑，这里安装的是YEdit

```yml
spring:
  application:
    name: eureka
server:
  port: 8761
eureka:
  client:
    service-url:
      defaultZone: http://127.0.0.1:8761/eureka
    register-with-eureka: false
```

将yml翻转成properties

|属性|描述|
|-|-|
|spring.application.name|应用名称，在eureka页面上显示服务的名称|
|server.port|http的端口号
|eureka.client.service-url.defaultZone|eureka注册地址
|eureka.client.register-with-eureka|eureka服务端不注册自己