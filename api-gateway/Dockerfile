FROM openjdk:8-jdk-alpine
ADD target/api-gateway.jar api-gateway.jar
EXPOSE 8080
ENTRYPOINT ["java" ,"-Djava.security.egd=file:/dev/./urandom",  "-jar", "api-gateway.jar"]
