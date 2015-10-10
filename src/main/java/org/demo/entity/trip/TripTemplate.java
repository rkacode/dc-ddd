package org.demo.entity.trip;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trip_template")
public class TripTemplate {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String referenceCode;

    private String description;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "trip_template")
    private Set<Ticket> tickets = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tripTemplate")
    private Set<TripEdition> tripEditions = new HashSet<>();

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


}
