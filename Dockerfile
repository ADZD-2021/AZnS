FROM ubuntu:20.04

RUN apt-get update && \
    apt-get install sudo -y && \
    apt-get install -y software-properties-common && \
    add-apt-repository ppa:openjdk-r/ppa -y && \
    apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y openjdk-17-jdk wget curl unzip zip jq build-essential gosu git

COPY target/Projekt-0.0.1-SNAPSHOT.jar Projekt-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Projekt-0.0.1-SNAPSHOT.jar"]
