FROM openjdk:8
ADD target/customer-app-docker-maven.jar customer-app-docker-maven.jar
EXPOSE 8081
CMD java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar customer-app-docker-maven.jar