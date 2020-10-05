package com.ameya.dropwizard.rabbitmqproducer.resources;

import com.ameya.dropwizard.rabbitmqproducer.core.RabbitMQHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/rabbitmq")
@Consumes(MediaType.APPLICATION_JSON)
public class PublishMessageResource {

    RabbitMQHandler rabbitMQHandler = new RabbitMQHandler();

    @POST
    @Path("/publish")
    public boolean publishMessage(String message) {
        return rabbitMQHandler.publishMessage(message);
    }
}
