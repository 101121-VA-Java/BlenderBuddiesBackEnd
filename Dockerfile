FROM openjdk:8-jdk-alpine
COPY target/blenderbuddies.jar blenderbuddies.jar 
ENTRYPOINT ["java", "-jar", "/blenderbuddies.jar"]
