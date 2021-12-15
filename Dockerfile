FROM openjdk:8-jdk-alpine
COPY target/datarest.jar  springdatarest.jar
ENTRYPOINT ["java", "-jar", "/springdatarest.jar"]
