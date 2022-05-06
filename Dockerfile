FROM openjdk:11
COPY ./target/client-service-1.0.jar client-service-1.0.jar
ENTRYPOINT ["java","-jar","/client-service-1.0.jar"]