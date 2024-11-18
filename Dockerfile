FROM amazoncorretto:21-alpine
LABEL authors="jonghak"

COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
