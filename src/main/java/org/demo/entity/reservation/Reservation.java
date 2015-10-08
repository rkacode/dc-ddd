package org.demo.entity.reservation;

import org.demo.annotations.AggregateRoot;
import org.demo.entity.roles.Agent;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
@AggregateRoot
public class Reservation {

    private String name;

    private String phoneNumber;

    private String roomNumber;

    private String extraInformation;

    private Agent agent;

    private Set<Ticket> tickets = new HashSet<Ticket>();


}
