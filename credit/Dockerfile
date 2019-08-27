FROM openjdk:8-jre
ADD target/credit-app-docker-maven.jar credit-app-docker-maven.jar
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "credit-app-docker-maven.jar"]