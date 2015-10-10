package org.demo.entity.trip;


import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TripFactoryTest {
        
    private TripFactory tripFactory;
    
    @Before
    public void setup() {
        tripFactory = new TripFactory();
    }

    @Test
    public void testSingleTripOption() {
        TripEdition tripEdition = new TripEdition();

        TripOption option1 = new TripOption();

        option1.setFromDate(LocalDate.of(2015, Month.OCTOBER, 1));
        option1.setToDate(LocalDate.of(2015, Month.OCTOBER, 31));
        option1.setWeekDay(DayOfWeek.MONDAY);

        tripEdition.getTripOptions().add(option1);

        List<Trip> tripsForEdition = tripFactory.createTripsForEdition(tripEdition);

        assertEquals(4, tripsForEdition.size());
    }

    @Test
    public void testSingleTripOptionWithFreeDays() {
        TripEdition tripEdition = new TripEdition();

        TripOption option1 = new TripOption();

        option1.setFromDate(LocalDate.of(2015, Month.OCTOBER, 1));
        option1.setToDate(LocalDate.of(2015, Month.OCTOBER, 31));
        option1.setWeekDay(DayOfWeek.MONDAY);
        option1.getFreeDays().add(LocalDate.of(2015, Month.OCTOBER, 12));


        tripEdition.getTripOptions().add(option1);

        List<Trip> tripsForEdition = tripFactory.createTripsForEdition(tripEdition);

        assertEquals(3, tripsForEdition.size());
    }

    @Test
    public void testTwoOptionsWithTheSameLanguage() {
        TripEdition tripEdition = new TripEdition();

        TripOption option1 = new TripOption();
        option1.setFromDate(LocalDate.of(2015, Month.OCTOBER, 1));
        option1.setToDate(LocalDate.of(2015, Month.OCTOBER, 31));
        option1.setWeekDay(DayOfWeek.MONDAY);
        option1.setHour("9:00");
        option1.setLanguage("English");
        option1.getFreeDays().add(LocalDate.of(2015, Month.OCTOBER, 12));

        TripOption option2 = new TripOption();
        option2.setFromDate(LocalDate.of(2015, Month.OCTOBER, 1));
        option2.setToDate(LocalDate.of(2015, Month.OCTOBER, 31));
        option2.setWeekDay(DayOfWeek.MONDAY);
        option2.setHour("9:00");
        option2.setLanguage("Polish");

        tripEdition.getTripOptions().add(option1);
        tripEdition.getTripOptions().add(option2);

        List<Trip> tripsForEdition = tripFactory.createTripsForEdition(tripEdition);

        assertEquals(7, tripsForEdition.size());
    }

}
