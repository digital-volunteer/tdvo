FROM 32bit/ubuntu:16.04
FROM openjdk:latest
COPY ./target/tdvo-0.0.1-SNAPSHOT.jar tdvo-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "tdvo-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080