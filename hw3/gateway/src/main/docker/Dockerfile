FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD gateway-docker.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
