FROM openjdk:8-jdk-alpine
MAINTAINER Paulo Ruszel
COPY target/agendamento-maplink-0.0.1-SNAPSHOT.jar agendamento.jar
ENTRYPOINT ["java","-jar","/agendamento.jar"]
