FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD calculator-docker.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
