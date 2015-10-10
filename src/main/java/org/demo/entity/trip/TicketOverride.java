package org.demo.entity.trip;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ticket_override")
public class TicketOverride {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    TripEdition tripEdition;

    @OneToMany
    private Set<Ticket> tickets = new HashSet<>();

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

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
