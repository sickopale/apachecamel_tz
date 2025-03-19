package org.acme.tz.camel.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Data
@NoArgsConstructor
@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    @XmlElement(name = "id")
    private Long orderId;

    @XmlElement(name = "customer")
    private String customer;

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    private List<Item> items;

}
