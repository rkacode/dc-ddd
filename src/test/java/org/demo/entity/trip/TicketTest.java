package org.demo.entity.trip;


import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TicketTest {

    @Test
    public void testTicketWithoutOptionsAreEqual() {
        Ticket ticket1 = new Ticket();
        ticket1.setName("Student");

        Ticket ticket2 = new Ticket();
        ticket2.setName("Student");

        assertEquals(ticket1, ticket2);
    }

    @Test
    public void testTicketWithOptionsAreEqual() {
        Ticket ticket1 = new Ticket();
        ticket1.setName("Student");

        TicketOption option1 = new TicketOption();
        option1.setFromCount(1);
        option1.setToCount(4);
        option1.setPrice(BigDecimal.valueOf(10));
        option1.setMarkup(BigDecimal.valueOf(2));

        ticket1.getOptions().add(option1);

        Ticket ticket2 = new Ticket();
        ticket2.setName("Student");

        TicketOption option2 = new TicketOption();
        option2.setFromCount(1);
        option2.setToCount(4);
        option2.setPrice(BigDecimal.valueOf(10));
        option2.setMarkup(BigDecimal.valueOf(2));

        ticket2.getOptions().add(option2);

        assertEquals(ticket1, ticket2);
    }

}