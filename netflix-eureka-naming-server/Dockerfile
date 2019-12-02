FROM openjdk:8-jre
ADD target/eureka-server.jar eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "eureka-server.jar"]