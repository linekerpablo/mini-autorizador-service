FROM openjdk:19-jdk-alpine
COPY card.transactions-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]