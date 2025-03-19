FROM openjdk:17-jdk-slim

WORKDIR /app

RUN mkdir -p /app/input

COPY target/camel-1.0.0-SNAPSHOT.jar app.jar

COPY input/* /app/input/

RUN chmod -R 777 /app/input

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
