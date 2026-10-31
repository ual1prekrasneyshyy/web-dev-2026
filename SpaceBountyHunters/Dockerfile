FROM openjdk:27-ea-jdk
WORKDIR /app
COPY . .
RUN ./gradlew build
RUN cp ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]