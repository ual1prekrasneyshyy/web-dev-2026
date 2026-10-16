FROM openjdk:28-ea-oracle
WORKDIR /app
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
