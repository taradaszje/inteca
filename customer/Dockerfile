FROM openjdk:8-jdk-alpine
ADD target/customer-service.jar customer-service.jar
EXPOSE 8070
CMD ["java" ,"-Djava.security.egd=file:/dev/./urandom" ,"-jar" ,"customer-service.jar"]
