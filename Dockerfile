# syntax=docker/dockerfile:1.7
FROM eclipse-temurin:25-jdk AS builder

WORKDIR /workspace
COPY gradlew gradlew.bat ./
COPY gradle gradle
COPY settings.gradle.kts build.gradle.kts ./
RUN chmod +x gradlew && ./gradlew dependencies --no-daemon

COPY src src
RUN ./gradlew clean bootJar --no-daemon

FROM eclipse-temurin:25-jre

RUN useradd --system --uid 10001 spring
WORKDIR /app
COPY --from=builder --chown=spring:spring /workspace/build/libs/*.jar app.jar
USER spring
EXPOSE 8080

ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75", "-jar", "/app/app.jar"]
