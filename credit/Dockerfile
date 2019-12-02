FROM openjdk:8-jdk-alpine
ADD target/credit-service.jar credit-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "credit-service.jar"]