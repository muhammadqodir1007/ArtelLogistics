# Use a base image with Java 17
FROM openjdk:17-oracle
# Set the working directory
WORKDIR /app

# Copy the JAR file to the container
COPY target/Artel-0.0.1-SNAPSHOT.jar.jar /myapp.jar

# Expose the port your app runs on
EXPOSE 8080

# Command to run your app
CMD ["java", "-jar", "/myapp.jar"]