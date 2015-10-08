package org.demo.entity.trip;

import org.demo.entity.reservation.Reservation;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trip {

    private int id;

    @OneToOne
    private TripEdition tripEdition;

    private Set<Reservation> reservations = new HashSet<>();

    private String language;

    private String date;

    private String hour;

    private boolean active;

    private int maxSeats;



}
