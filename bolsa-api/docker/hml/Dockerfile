FROM openjdk:11
COPY bolsa-api-*.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=hml","-jar","/app.jar"]