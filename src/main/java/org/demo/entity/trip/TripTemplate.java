package org.demo.entity.trip;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TripTemplate {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String referenceCode;

    private String description;

    @OneToMany
    private Set<Ticket> tickets = new HashSet<Ticket>();

    @OneToMany
    private Set<TripEdition> tripEditions = new HashSet<TripEdition>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Set<TripEdition> getTripEditions() {
        return tripEditions;
    }

    public void setTripEditions(Set<TripEdition> tripEditions) {
        this.tripEditions = tripEditions;
    }

    public TripEdition createNewTripEdition() {
        return null;
    }
}
