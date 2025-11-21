FROM openjdk:17.0.2
VOLUME /tmp
ADD target/campushub-config-service.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]