FROM openjdk:28-ea-oracle
WORKDIR /app
COPY ./build/libs/*.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]