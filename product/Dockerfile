FROM openjdk:8-jdk-alpine
ADD target/product-service.jar product-service.jar
EXPOSE 8090
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom" , "-jar", "product-service.jar"]
