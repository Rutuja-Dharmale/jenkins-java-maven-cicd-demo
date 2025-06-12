# Stage 1: Build Java app using Maven
FROM maven:3.8.5-openjdk-17-slim AS builder
WORKDIR /app
COPY . .
RUN mvn clean package

# Stage 2: Run app from built jar
FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]

