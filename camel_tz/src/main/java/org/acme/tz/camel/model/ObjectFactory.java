package org.acme.tz.camel.model;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public Order createOrder() {
        return new Order();
    }
}