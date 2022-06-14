FROM ubuntu:20.04

ARG test
ARG binary_name

RUN apt-get update && \
    apt-get install sudo -y && \
    apt-get install -y software-properties-common && \
    add-apt-repository ppa:openjdk-r/ppa -y && \
    apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y openjdk-8-jdk openjdk-8-dbg wget curl unzip zip jq python3-pip python-is-python3 build-essential gosu && \
    pip3 install --upgrade pip


# copy/download build binary

RUN chmod +x {{ binary_name }}.war
RUN chomd +x startup.sh

CMD exec startup.sh
