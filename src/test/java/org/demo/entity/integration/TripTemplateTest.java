package org.demo.entity.integration;

import org.demo.entity.trip.Ticket;
import org.demo.entity.trip.TicketOption;
import org.demo.entity.trip.TripTemplate;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class TripTemplateTest {

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
    public void testSaveTripTemplate() {
        entityManager.getTransaction().begin();

        TripTemplate tripTemplate = new TripTemplate();
        tripTemplate.setName("001 Auschwitz");
        tripTemplate.setDescription("Trip to Auschwitz");
        tripTemplate.setReferenceCode("001XYZ");

        Ticket ticket = new Ticket("Student");
        TicketOption option1 = new TicketOption();
        option1.setFromCount(1);
        option1.setToCount(15);
        option1.setPrice(BigDecimal.valueOf(10));
        option1.setMarkup(BigDecimal.valueOf(3));
        ticket.getOptions().add(option1);

        tripTemplate.getTickets().add(ticket);

        entityManager.persist(tripTemplate);

        entityManager.getTransaction().commit();
    }

}
