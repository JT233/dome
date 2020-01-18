# 项目介绍
本项目是用来学习springclound的示例项目，主要包括注册中心及注册中心集群；
服务间的调用（ribbon及Feign）；熔断器；配置中心；服务网关等。

* springclound01 分支
用于演示基于maven多模块的微服务项目搭建，注册中心，及服务的注册于发现

* springclound02 分支
用于演示注册中心集群

* springclound03_01 分支 
用于演示熔断器的基本使用, hytrix dashboard监控面板的基本使用（只能监控单个服务实例，如果
需要监控集群服务则可参数springclound03_02分支）

* springclound03_02 分支
加入了Turbine集群监控面板配置示例。