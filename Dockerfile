#FROM maven:3.8.6-openjdk-11 AS build
#
#WORKDIR /Artel
#COPY . .
#RUN mvn clean package
#
#FROM openjdk:11-jre-slim
#COPY --from=build /Artel/target/Artel-0.0.1-SNAPSHOT.jar /Artel-0.0.1-SNAPSHOT.jar
#EXPOSE 8080
#CMD ["java", "-jar", "/Artel-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Artel-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/Artel-0.0.1-SNAPSHOT.jar"]