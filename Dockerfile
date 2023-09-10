# 基础镜像
FROM openjdk:17-jdk-alpine
# author
MAINTAINER xtrape
# 挂载目录
VOLUME /home/xtrape
# 创建目录
RUN mkdir -p /home/xtrape
# 指定路径
WORKDIR /home/xtrape
# 复制jar文件到路径
COPY ./target/xtrape-content.jar /home/xtrape/xtrape-content.jar
# 启动系统服务
ENTRYPOINT java $JAVA_OPTS -jar xtrape-content.jar
