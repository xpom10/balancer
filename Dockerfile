FROM openjdk:8-jdk-alpine
COPY target/balancer.jar balancer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./balancer.jar"]