FROM openjdk:17
COPY target/app.jar app.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "/app.jar"]

#Build App
