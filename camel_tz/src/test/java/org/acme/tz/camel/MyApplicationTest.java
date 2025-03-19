package org.acme.tz.camel;

import java.util.concurrent.TimeUnit;

import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.test.main.junit5.CamelMainTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MyApplicationTest extends CamelMainTestSupport {

    @Override
    protected Class<?> getMainClass() {
        // The main class of the application to test
        return MyApplication.class;
    }

}
