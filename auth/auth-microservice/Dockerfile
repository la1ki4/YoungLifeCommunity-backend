FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY /target/auth-microservice-0.0.1-SNAPSHOT.jar /app/auth-microservice.jar
ENTRYPOINT ["java", "-jar", "auth-microservice.jar"]