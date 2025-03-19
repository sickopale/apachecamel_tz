FROM maven:3.8-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

RUN mkdir -p /app/input

COPY --from=build /app/target/camel-1.0.0-SNAPSHOT.jar app.jar

COPY input/* /app/input/

RUN chmod -R 777 /app/input

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
