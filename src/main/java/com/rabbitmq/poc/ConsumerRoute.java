package com.rabbitmq.poc;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("rabbitmq:my-exch?routingKey=emp&connectionFactory=#rabbitConnectionFactory&vhost=/")
                .routeId("ConsumerRoute")
                .log(LoggingLevel.INFO, "BODY-->>  :: ${body}")

                .to("mock:end")
                .end();
        ;
    }
}
