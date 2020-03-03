FROM ubuntu:16.04

RUN apt-get update

RUN apt-get update && apt-get install -y \ default-jre \ default-jdk \ git \ maven

RUN mvn -version

RUN git clone -b master https://github.com/Steavy/cucumber-testframework.git

CMD ls RUN cd cucumber-testframework && mvn -Dtest=CukesRunner test
