package org.demo.entity.integration;


import org.demo.entity.trip.*;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

public class TripEditionTest {
    private static EntityManagerFactory factory;

    private EntityManager entityManager;

    @BeforeClass
    public static void beforeClass() {
        factory = Persistence.createEntityManagerFactory("mysql");
    }

    @AfterClass
    public static void afterClass() {
        factory.close();
    }

    @Before
    public void before() {
        entityManager = factory.createEntityManager();
    }

    @After
    public void after() {
        entityManager.close();
    }

    @Test
    public void testSaveTripEdition() {
        entityManager.getTransaction().begin();

        TripTemplate template = entityManager.find(TripTemplate.class, 1);
        TripEdition edition = new TripEdition();
        edition.setTripTemplate(template);

        Set<Ticket> copied = copyTicketsFromTemplate(template.getTickets());
        edition.getTickets().addAll(copied);

        TripOption option = new TripOption();
        option.setHour("9:00");
        option.setLanguage("Polish");
        option.setMaxSeats(15);
        option.setWeekDay(DayOfWeek.FRIDAY);
        option.setFromDate(LocalDate.of(2015, Month.AUGUST, 1));
        option.setToDate(LocalDate.of(2015, Month.AUGUST, 31));

        edition.getTripOptions().add(option);

        template.getTripEditions().add(edition);

        entityManager.getTransaction().commit();

    }

    private Set<Ticket> copyTicketsFromTemplate(Set<Ticket> tickets) {
        Set<Ticket> copied = new HashSet<>();

        for (Ticket ticket : tickets) {
            Ticket t = new Ticket();
            t.setName(ticket.getName());
            t.setOptions(copyTicketOptions(ticket.getOptions()));
            copied.add(t);
        }

        return copied;
    }

    private Set<TicketOption> copyTicketOptions(Set<TicketOption> options) {
        Set<TicketOption> copied = new HashSet<>();

        for (TicketOption option : options) {
            copied.add(new TicketOption(option));
        }

        return copied;
    }

}
