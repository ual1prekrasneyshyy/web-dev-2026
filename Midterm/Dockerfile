FROM openjdk:28-ea-oracle
WORKDIR /app
CMD ./gradlew clean
CMD ./gradlew build
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
