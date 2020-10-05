package com.ameya.dropwizard.rabbitmqconsumer;

import com.ameya.dropwizard.rabbitmqconsumer.resources.ConsumeMessageResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RabbitMQConsumerApplication extends Application<RabbitMQConsumerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RabbitMQConsumerApplication().run(args);
    }

    @Override
    public String getName() {
        return "RabbitMQConsumer";
    }

    @Override
    public void initialize(final Bootstrap<RabbitMQConsumerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final RabbitMQConsumerConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application

        ConsumeMessageResource consumeMessageResource = new ConsumeMessageResource();
        environment.jersey().register(consumeMessageResource);
    }

}
