FROM openjdk:21-jdk-alpine
WORKDIR /app
COPY target/*.jar pedeaiauth.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "pedeaiauth.jar"]