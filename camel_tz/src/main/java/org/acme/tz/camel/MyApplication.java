package org.acme.tz.camel;

import org.acme.tz.camel.routes.OrderRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public final class MyApplication {

    public static void main(String[] args) throws Exception {

        CamelContext context=new DefaultCamelContext();
        context.addRoutes(new OrderRoute());
        context.start();

        Thread.sleep(50000);
        context.stop();
    }

}
