FROM openjdk:21-jdk
WORKDIR /app
COPY target/*.jar pedeaiauth.jar
ENTRYPOINT ["java", "-jar", "pedeaiauth.jar"]