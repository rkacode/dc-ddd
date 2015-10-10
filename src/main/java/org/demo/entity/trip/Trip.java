package org.demo.entity.trip;

import org.demo.entity.reservation.Reservation;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "trip_edition")
    private TripEdition tripEdition;

    @OneToMany(mappedBy = "trip")
    private Set<Reservation> reservations = new HashSet<>();

    private String language;

    private LocalDate date;

    private String hour;

    private boolean active;

    private int maxSeats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TripEdition getTripEdition() {
        return tripEdition;
    }

    public void setTripEdition(TripEdition tripEdition) {
        this.tripEdition = tripEdition;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }
}
