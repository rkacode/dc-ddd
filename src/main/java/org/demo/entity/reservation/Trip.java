package org.demo.entity.reservation;

import java.util.HashSet;
import java.util.Set;

public class Trip {

    private String name;

    private String hour;

    private String language;

    private String date;

    private Set<Reservation> reservations = new HashSet<Reservation>();


    public void bookReservation() {

    }

}
