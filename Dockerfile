# Build Stage
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# Copy only the POM file first to leverage Docker cache
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the rest of the application files
COPY src src

# Build the application
RUN mvn package

# Runtime Stage
FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

# Copy the JAR file from the build stage
COPY --from=build /app/target/Artel-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
