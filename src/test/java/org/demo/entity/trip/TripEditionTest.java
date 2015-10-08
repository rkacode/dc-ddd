package org.demo.entity.trip;

import com.google.common.collect.ImmutableSet;
import org.demo.entity.roles.Agent;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TripEditionTest {

    private TripEdition tripEdition;

    @Before
    public void setup() {
        tripEdition = new TripEdition();
        Agent goldenLion = new Agent();
        goldenLion.setName("Golden Lion");
        tripEdition.setTickets(createTickets());
        tripEdition.getOverrides().put(goldenLion, createTicketsForGoldenLion());
    }

    @Test
    public void testStudentTicketForGoldenLion() {
        Agent goldenLion = new Agent();
        goldenLion.setName("Golden Lion");

        Set<Ticket> tickets = tripEdition.getTicketsForAgent(goldenLion);

        assertEquals(2, tickets.size());

        Ticket studentTicket = findStudentTicket(tickets);

        assertEquals("Student", studentTicket.getName());

    }

    private Ticket findStudentTicket(Set<Ticket> tickets) {
        return tickets.stream()
                .filter(t -> t.name.equals("Student"))
                .findFirst().orElseThrow(() -> new RuntimeException("Student ticket not found!"));
    }

    private Set<Ticket> createTickets() {
        Ticket adultTicket = new Ticket();
        adultTicket.setId(1);
        adultTicket.setName("Adult");

        TicketOption adult1To3 = new TicketOption();
        adult1To3.setFrom(1);
        adult1To3.setTo(3);
        adult1To3.setPrice(BigDecimal.valueOf(15.00));


        TicketOption adult4to7 = new TicketOption();
        adult4to7.setFrom(4);
        adult4to7.setTo(7);
        adult4to7.setPrice(BigDecimal.valueOf(12.00));

        adultTicket.getOptions().add(adult1To3);
        adultTicket.getOptions().add(adult4to7);


        Ticket studentTicket = new Ticket();
        studentTicket.setId(2);
        studentTicket.setName("Student");

        TicketOption student1 = new TicketOption();
        student1.setFrom(1);
        student1.setPrice(BigDecimal.valueOf(9.00));
        studentTicket.getOptions().add(student1);

        return ImmutableSet.of(adultTicket, studentTicket);
    }

    private Set<Ticket> createTicketsForGoldenLion() {
        Ticket studentTicket = new Ticket();
        studentTicket.setId(2);
        studentTicket.setName("Student");

        TicketOption student1 = new TicketOption();
        student1.setFrom(1);
        student1.setPrice(BigDecimal.valueOf(5.00));
        studentTicket.getOptions().add(student1);

        return ImmutableSet.of(studentTicket);
    }

}