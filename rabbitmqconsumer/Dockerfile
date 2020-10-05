FROM openjdk:11

EXPOSE 8080
EXPOSE 8081
EXPOSE 5672


ADD ./target/rabbitmqconsumer-1.0.0.jar consumer.jar
ADD ./config.yml config.yml
CMD ["java", "-jar", "consumer.jar", "server", "config.yml"]