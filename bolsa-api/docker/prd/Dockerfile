FROM openjdk:11
COPY consulta-cep-*.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prd","-jar","/app.jar"]