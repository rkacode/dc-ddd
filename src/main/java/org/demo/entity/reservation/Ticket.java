package org.demo.entity.reservation;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

public class Ticket {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int count;

    private BigDecimal price;

    private BigDecimal markup;



}
