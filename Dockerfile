FROM --platform=linux/amd64 openjdk:17-jdk
VOLUME /tmp
COPY target/*.jar app.jar
Expose 8080
ENTRYPOINT ["java","-jar","/app.jar"]