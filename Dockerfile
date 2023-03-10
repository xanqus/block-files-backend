FROM openjdk:17-alpine
CMD ["./mvnw", "clean", "package"]
ARG JAR_FILE_PATH=*.jar
COPY ${JAR_FILE_PATH} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

