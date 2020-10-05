package com.ameya.dropwizard.rabbitmqproducer.core;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.ameya.dropwizard.rabbitmqproducer.constants.QueueConstants.QUEUE_NAME;

public class RabbitMQHandler {


    public ConnectionFactory getConnectionFactory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("0.0.0.0");
        return connectionFactory;
    }

    public boolean publishMessage(String message) {
        ConnectionFactory connectionFactory = getConnectionFactory();
        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("[x] Sent : " + message);
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
