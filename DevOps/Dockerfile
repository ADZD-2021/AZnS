FROM ubuntu:20.04

ARG binary_name

RUN apt-get update && \
    apt-get install sudo -y && \
    apt-get install -y software-properties-common && \
    add-apt-repository ppa:openjdk-r/ppa -y && \
    apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y openjdk-8-jdk openjdk-8-dbg wget curl unzip zip jq python3-pip python-is-python3 build-essential gosu git && \
    pip3 install --upgrade pip


# copy/download build binary
# CMD wget https://github.com/ADZD-2021/AZnS/raw/devops_dev/target/Projekt-0.0.1-SNAPSHOT.war

# RUN chmod +x {{ binary_name }}.war
RUN git clone https://github.com/ADZD-2021/AZnS.git
RUN cd AZnS/ && git checkout devops_dev && cd DevOps/ && chmod +x startup.sh
# RUN cd DevOps/
# RUN chmod +x startup.sh

CMD exec AZnS/DevOps/startup.sh
# CMD sleep 10000
