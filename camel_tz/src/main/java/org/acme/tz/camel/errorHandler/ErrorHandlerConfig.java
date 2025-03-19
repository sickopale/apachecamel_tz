package org.acme.tz.camel.errorHandler;

import com.fasterxml.jackson.core.JacksonException;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.DeadLetterChannelBuilder;
import org.apache.camel.http.base.HttpOperationFailedException;
import org.apache.camel.model.errorhandler.DefaultErrorHandlerDefinition;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.camel.builder.RouteBuilder;

public class ErrorHandlerConfig {

    public static DefaultErrorHandlerDefinition createDefaultErrorHandler() {
        return new DeadLetterChannelBuilder("direct:handleError")
                .loggingLevel(LoggingLevel.OFF)
                .logStackTrace(false)
                .logExhaustedMessageHistory(false)
                .logHandled(false)
                .logRetryAttempted(false);
    }

    public static void configureExceptionHandling(RouteBuilder routeBuilder) {

        routeBuilder
                .onException(Exception.class)
                .log(LoggingLevel.WARN, "Error during processing: ${header.CamelFileName}")
                .retriesExhaustedLogLevel(LoggingLevel.WARN)
                .logStackTrace(false);

        routeBuilder
                .onException(JacksonException.class)
                .log(LoggingLevel.WARN, "Error during converting JSON file: ${header.CamelFileName}")
                .retriesExhaustedLogLevel(LoggingLevel.WARN)
                .logStackTrace(false);

        routeBuilder
                .onException(HttpHostConnectException.class)
                .log(LoggingLevel.WARN, "Error during connection, redelivery attempts : 5")
                .maximumRedeliveries("5")
                .redeliveryDelay(1000)
                .retriesExhaustedLogLevel(LoggingLevel.WARN)
                .logStackTrace(false);

        routeBuilder
                .onException(HttpOperationFailedException.class)
                .log(LoggingLevel.WARN, "The server returned an error for file : ${header.CamelFileName}")
                .maximumRedeliveries("0")
                .retriesExhaustedLogLevel(LoggingLevel.WARN)
                .logStackTrace(false);

    }
}
