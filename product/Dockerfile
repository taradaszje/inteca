FROM openjdk:8
ADD target/product-app-docker-maven.jar product-app-docker-maven.jar
EXPOSE 8080
CMD java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar product-app-docker-maven.jar