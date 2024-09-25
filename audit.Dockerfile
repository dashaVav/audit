FROM openjdk:21-slim
LABEL authors="dashavav"
COPY target/audit*.jar /audit.jar
ENTRYPOINT ["java", "-jar", "/audit.jar"]