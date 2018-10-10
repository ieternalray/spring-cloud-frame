# spring-cloud-frame

### 序
>（项目与文档待完善）项目是基于Spring Cloud 作者本人为方便快速搭建项目做的一个脚手架，前后端分离，该项目为后端代码。
项目会不断更新，直至该项目趋于完善。代码如有不规范或错误之处，请发送邮件至1339630595@qq.com,
定第一时间解决，在此谢谢各位了。
## 项目环境

* JAVA 8
* Maven 3.5.4
* Redis 3.2.12
* 数据库 MySQL

## 模块介绍
* 主模块 spring-cloud-frame
* 注册中心 eureka-server
* 路由网关 zuul
* 用户中心 user

## 注意事项
* 主配置文件已规范化项目公用部分配置MAVEN版本号，请注意版本冲突问题
* 模块安全注意事项(如若使用该项目，务必修改以下配置)
> * JwtUtil - 常量 SECRET
> * DruidConfig - 常量 DRUID_USERNAME,DRUID_PASSWORD
