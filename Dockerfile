# Stage 1: Build
FROM openjdk:17-jdk-slim AS builder
WORKDIR /app

# Copy Gradle build files
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle/

# Download dependencies
RUN ./gradlew dependencies --no-daemon

# Copy source code and build the application
COPY src /app/src
RUN ./gradlew bootJar --no-daemon

# Stage 2: Runtime
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/build/libs/surprise-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the application's port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]