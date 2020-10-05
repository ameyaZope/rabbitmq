package com.ameya.dropwizard.rabbitmqconsumer.core;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.ameya.dropwizard.rabbitmqconsumer.constants.GlobalConstants.HOST_NAME;
import static com.ameya.dropwizard.rabbitmqconsumer.constants.GlobalConstants.QUEUE_NAME;

public class RabbitMQHandler {
    public ConnectionFactory getConnectionFactory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("0.0.0.0");
        return connectionFactory;
    }

    public String consumeMessage() {
        ConnectionFactory connectionFactory = getConnectionFactory();

        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            DeliverCallback deliverCallback = (consumeTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println("[x] Received : " + message);
            };
//            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag->{});
            return new String(channel.basicGet(QUEUE_NAME, true).getBody());
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}
