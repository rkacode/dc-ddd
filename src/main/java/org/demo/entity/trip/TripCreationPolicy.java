package org.demo.entity.trip;


import java.time.LocalDate;

public interface TripCreationPolicy extends Policy {

    boolean shouldCreateTrip(LocalDate forDate, TripOption forOption);

}
