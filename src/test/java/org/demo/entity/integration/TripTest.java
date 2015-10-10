package org.demo.entity.integration;

import org.demo.entity.trip.Ticket;
import org.demo.entity.trip.TripEdition;
import org.demo.entity.trip.TripOption;
import org.demo.entity.trip.TripTemplate;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

public class TripTest {
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
    public void testSaveTrip() {
        entityManager.getTransaction().begin();

        entityManager.find(TripEdition.class, 1);

        entityManager.getTransaction().commit();

    }
}
