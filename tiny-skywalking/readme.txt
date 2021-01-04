外部的链路追踪
SkyWalking探针配置

增加如下参数：
修改成自己的路径，服务名，地址

-javaagent:D:\dev\workspace\spring-cloud-alibaba-template\tiny-skywalking\agent\skywalking-agent.jar
-Dskywalking.agent.service_name=service-user
-Dskywalking.collector.backend_service=127.0.0.1:11800


方式一：java xx -xx.jar

方式二：idea配置
