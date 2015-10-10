package org.demo.entity.trip;

import java.time.LocalDate;

public class FreeDayPolicy implements TripCreationPolicy {
    @Override
    public boolean shouldCreateTrip(LocalDate forDate, TripOption forOption) {
        return !forOption.getFreeDays().contains(forDate);
    }

    @Override
    public String getName() {
        return "Free day";
    }
}
