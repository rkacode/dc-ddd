package org.demo;


import com.google.common.collect.ImmutableSet;
import org.demo.entity.roles.Agent;
import org.demo.entity.trip.*;

import java.math.BigDecimal;
import java.util.Set;

public class App
{
    public static void main( String[] args )
    {

    }

    public void createTripTemplate() {
        TripTemplate tripTemplate = new TripTemplate();
        tripTemplate.setId(1);
        tripTemplate.setDescription("Amazing trip to Wieliczka salt mine");
        tripTemplate.setReferenceCode("001-XFZ12AR");

        Set<Ticket> tickets = createTickets();
        tripTemplate.getTickets().addAll(tickets);

        TripEdition tripEdition = new TripEdition();

        TripOption option1 = new TripOption();
        option1.setDateFrom("01.11.2015");
        option1.setDateTo("12.11.2015");
        option1.setHour("9:00");
        option1.setLanguage("Polish");
        option1.setMaxSeats(30);
        option1.setWeekDay("Monday");

        TripOption option2 = new TripOption();
        option2.setDateFrom("01.11.2015");
        option2.setDateTo("09.11.2015");
        option2.setHour("9:00");
        option2.setLanguage("English");
        option2.setMaxSeats(15);
        option2.setWeekDay("Monday");

        TripOption option3 = new TripOption();
        option3.setDateFrom("01.11.2015");
        option3.setDateTo("09.11.2015");
        option3.setHour("9:00");
        option3.setLanguage("English");
        option3.setMaxSeats(15);
        option3.setWeekDay("Monday");

        tripEdition.getTripOptions().add(option1);
        tripEdition.getTripOptions().add(option2);
        tripEdition.getTripOptions().add(option3);

        Agent goldenLion = new Agent();
        goldenLion.setName("Golden Lion");

        Agent blackGarden = new Agent();
        blackGarden.setName("Black Garden");

        tripEdition.getOverrides().put(goldenLion, createTicketsForGoldenLion());


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
