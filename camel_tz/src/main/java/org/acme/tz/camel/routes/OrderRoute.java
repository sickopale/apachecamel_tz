package org.acme.tz.camel.routes;

import org.acme.tz.camel.errorHandler.ErrorHandlerConfig;
import org.acme.tz.camel.model.Order;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;

public class OrderRoute extends RouteBuilder {

    @Override
    public void configure() {

        DataFormat jaxb= new JaxbDataFormat("org.acme.tz.camel.model");
        JacksonDataFormat json= new JacksonDataFormat(Order.class);

        errorHandler(ErrorHandlerConfig.createDefaultErrorHandler());
        ErrorHandlerConfig.configureExceptionHandling(this);

        from("file:input?include=.*\\.json&moveFailed=error&move=processed")
                .log("Processing file: ${header.CamelFileName}")
                .log("Processing JSON: \n" + " ${body}")
                .unmarshal(json)
                .marshal(jaxb)
                .log("XML: \n" + "${body}")
                .setHeader("CamelFileName", simple("${file:name.noext}.xml"))
                .setHeader("Content-Type", constant("application/xml"))
                .to("http://localhost:8080/orders?bridgeEndpoint=true")
                .log("XML has been sent to REST API")
                .end();
    }
}
