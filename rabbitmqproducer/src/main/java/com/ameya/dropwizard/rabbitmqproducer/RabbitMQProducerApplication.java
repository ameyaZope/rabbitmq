package com.ameya.dropwizard.rabbitmqproducer;

import com.ameya.dropwizard.rabbitmqproducer.resources.PublishMessageResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RabbitMQProducerApplication extends Application<RabbitMQProducerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RabbitMQProducerApplication().run(args);
    }

    @Override
    public String getName() {
        return "RabbitMQProducer";
    }

    @Override
    public void initialize(final Bootstrap<RabbitMQProducerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final RabbitMQProducerConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        PublishMessageResource publishMessageResource = new PublishMessageResource();
        environment.jersey().register(publishMessageResource);
    }

}
