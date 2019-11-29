FROM openjdk:8
ADD target/product-service.jar product-service.jar
EXPOSE 8080
CMD java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -DEUREKA_SERVER=http://eureka-server:8761/eureka -jar product-service.jar