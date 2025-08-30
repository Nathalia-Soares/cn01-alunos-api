FROM gradle:8.9-jdk21 AS build
WORKDIR /app

COPY . .

RUN gradle clean bootJar --no-daemon

FROM openjdk:21-jdk-slim
WORKDIR /app

COPY --from=build /app/build/libs/alunos-api.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
