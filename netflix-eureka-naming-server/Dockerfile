FROM openjdk:8-jdk-alpine
ADD target/eureka-server.jar eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "eureka-server.jar"]
