package org.demo.entity.reservation;

import org.demo.annotations.AggregateRoot;
import org.demo.entity.roles.Agent;
import org.demo.entity.trip.Ticket;
import org.demo.entity.trip.Trip;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AggregateRoot
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Trip trip;

    private String name;

    private String phoneNumber;

    private String roomNumber;

    private String extraInformation;

    @ManyToOne
    private Agent agent;

    @OneToMany
    private Set<Ticket> tickets = new HashSet<>();


}
