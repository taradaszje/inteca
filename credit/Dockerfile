FROM openjdk:8-jre
ADD target/credit-service.jar credit-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-DEUREKA_SERVER=http://eureka-server:8761/eureka", "-jar", "credit-service.jar"]