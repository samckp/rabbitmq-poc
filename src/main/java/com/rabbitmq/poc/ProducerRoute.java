package com.rabbitmq.poc;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("{{inputPath}}")
                .routeId("SimpleRoute")
                .log(LoggingLevel.INFO, "BODY-->>  :: ${body}")

                .to("rabbitmq:amq.direct?connectionFactory=#rabbitConnectionFactory&queue=asia-queue&declare=false&autoDelete=false&autoAck=true")
                .end();
        ;
    }
}
