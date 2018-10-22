http://localhost:8888/config/dev/master
2.启动配置文件

在配置文件resources/bootstrap.properties中做如下配置：
spring.application.name=config
spring.cloud.config.lable=master
spring.cloud.config.profile=test
spring.cloud.config.uri=http://localhost:8888/
server.port=8888
spring.application.name：对应{application}，本实例中是config；
spring.cloud.config.label：对应{label}，指定server端配置的分支，此处填master即可；
spring.cloud.config.profile：对应{profile}，指定client当前的环境，可选值：dev，test，pro；
spring.cloud.config.uri：server端地址；
server.port：client启动端口；