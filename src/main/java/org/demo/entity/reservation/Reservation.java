package org.demo.entity.reservation;

import org.demo.annotations.AggregateRoot;
import org.demo.entity.roles.Agent;
import org.demo.entity.trip.Trip;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
@AggregateRoot
public class Reservation {

    @ManyToOne
    private Trip trip;

    private String name;

    private String phoneNumber;

    private String roomNumber;

    private String extraInformation;

    private Agent agent;

    private Set<Ticket> tickets = new HashSet<Ticket>();


}
