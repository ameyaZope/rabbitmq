FROM openjdk:11

EXPOSE 8080
EXPOSE 8081
EXPOSE 5672
EXPOSE 15672

ADD ./target/rabbitmqproducer-1.0.0.jar producer.jar
ADD ./config.yml config.yml
CMD ["java", "-jar", "producer.jar", "server", "config.yml"]