FROM openjdk:19-jdk-alpine
MAINTAINER baeldung.com
COPY target/card.transactions-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]