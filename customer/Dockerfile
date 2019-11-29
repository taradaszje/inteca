FROM openjdk:8
ADD target/customer-service.jar customer-service.jar
EXPOSE 8081
CMD java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -DEUREKA_SERVER=http://eureka-server:8761/eureka -jar customer-service.jar