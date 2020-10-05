package com.ameya.dropwizard.rabbitmqconsumer.resources;

import com.ameya.dropwizard.rabbitmqconsumer.core.RabbitMQHandler;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rabbitmq")
@Produces(MediaType.APPLICATION_JSON)
public class ConsumeMessageResource {

    RabbitMQHandler rabbitMQHandler;

    public ConsumeMessageResource() {
        rabbitMQHandler = new RabbitMQHandler();
    }

    @GET
    @Timed
    @Path("/consume")
    public String getMessageFromQueue() {
        return rabbitMQHandler.consumeMessage();
    }

}
