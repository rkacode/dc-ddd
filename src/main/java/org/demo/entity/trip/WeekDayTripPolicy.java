package org.demo.entity.trip;


import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekDayTripPolicy implements TripCreationPolicy {
    @Override
    public boolean shouldCreateTrip(LocalDate forDate, TripOption forOption) {
        DayOfWeek dayOfWeek = forDate.getDayOfWeek();
        return forOption.getWeekDay() == dayOfWeek;
    }

    @Override
    public String getName() {
        return "Week day";
    }
}
