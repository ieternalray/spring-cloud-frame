# spring-cloud-frame

### 序
>项目是基于Spring Cloud 作者本人为方便快速搭建项目做的一个脚手架，前后端分离，该项目为后端代码。
项目会不断更新，直至该项目趋于完善。代码如有不规范或错误之处，请发送邮件至1339630595@qq.com,
定第一时间解决，在此谢谢各位了。
## 项目环境

* JAVA 8
* 数据库 MySQL
* 缓存 Redis

## 项目关系与流程
*   项目使用请求路径鉴权的方式进行接口数据交互，接口统一返回JSON，返回格式如下{"success":true,"data":""},
正确返回true，错误返回false，结果体包含在data中
*  用户-->角色->权限  例：用户A包含B1、B2角色，B1拥有URL1权限，B2拥有URL2权限，则A可请求URL1和URL2
*   1. 用户登陆，获取token与其他相应信息
    2. 使用token鉴权进行接口访问

## 模块介绍
|模块功能|服务|端口
|:---:|:---:|:---:|
|主模块|spring-cloud-frame|
|注册中心|eureka-server|6001
|路由网关|zuul|8001
|用户中心|user|7001


## 注意事项
* 主配置文件已规范化项目公用部分配置MAVEN版本号，请注意版本冲突问题
* 模块安全注意事项(如若使用该项目，务必修改以下配置)
> * JwtUtil - 常量 SECRET
> * DruidConfig - 常量 DRUID_USERNAME,DRUID_PASSWORD
