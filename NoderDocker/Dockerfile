FROM openjdk:11
COPY ./target/NoderDocker-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch NoderDocker-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","NoderDocker-0.0.1-SNAPSHOT.jar"]
