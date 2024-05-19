# Use the official OpenJDK 17 image as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper and related files
COPY gradlew .
COPY gradle /app/gradle

# Copy the rest of the application source code
COPY . .

# Grant execution rights to the Gradle wrapper
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build

# Use a second, smaller image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the previous build stage
COPY --from=0 /app/build/libs/*.jar app.jar

# Expose the port that the application runs on
EXPOSE 8080

# Set the entrypoint to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
