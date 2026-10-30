FROM openjdk:27-ea-jdk
WORKDIR /app
#COPY . .
#RUN ./gradlew build
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
