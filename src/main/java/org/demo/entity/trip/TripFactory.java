package org.demo.entity.trip;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripFactory {
    private static final Logger LOG = LoggerFactory.getLogger(TripFactory.class);

    private Set<TripCreationPolicy> creationPolicies = new HashSet<>();

    public TripFactory() {
        creationPolicies.add(new WeekDayTripPolicy());
        creationPolicies.add(new FreeDayPolicy());
    }

    List<Trip> createTripsForEdition(TripEdition tripEdition) {
        List<Trip> trips = new ArrayList<>();

        for (TripOption option : tripEdition.getTripOptions()) {
            trips.addAll(createTripsForTripOption(tripEdition, option));
        }

        return trips;
    }

    private List<Trip> createTripsForTripOption(TripEdition edition, TripOption tripOption) {
        LocalDate current = tripOption.getFromDate();

        List<Trip> trips = new ArrayList<>();

        while (isBeforeOrEqual(current, tripOption.getToDate())) {
            boolean shouldBeCreated = checkPolicies(current, tripOption);

            if (shouldBeCreated) {
                LOG.info("Creating trip for date {}", current);

                Trip trip = new Trip();
                trip.setTripEdition(edition);
                trip.setActive(true);
                trip.setDate(current);
                trip.setHour(tripOption.getHour());
                trip.setLanguage(tripOption.getLanguage());
                trip.setMaxSeats(tripOption.getMaxSeats());

                trips.add(trip);
            }

            current = current.plusDays(1);
        }

        return trips;
    }

    private boolean checkPolicies(LocalDate current, TripOption tripOption) {
        for (TripCreationPolicy creationPolicy : creationPolicies) {
            boolean shouldBeCreated = creationPolicy.shouldCreateTrip(current, tripOption);
            if (!shouldBeCreated) {
                LOG.info("Trip for date {} will not be created because is not allowed by the {} policy",
                        current, creationPolicy.getName());
                return false;
            }
        }

        return true;
    }

    private boolean isBeforeOrEqual(LocalDate current, LocalDate to) {
        return current.isBefore(to) || current.isEqual(to);
    }

}
