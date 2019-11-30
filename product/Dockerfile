FROM openjdk:8-jdk-alpine
ADD target/product-service.jar product-service.jar
EXPOSE 8080
CMD java -Djava.security.egd=file:/dev/./urandom  -jar product-service.jar