package org.demo.entity.trip;

import org.demo.entity.roles.Agent;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "trip_edition")
public class TripEdition {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "trip_template")
    private TripTemplate tripTemplate;

    @OneToMany(mappedBy = "tripEdition", cascade = CascadeType.ALL)
    private Map<Agent, TicketOverride> overrides = new HashMap<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<TripOption> tripOptions = new HashSet<>();

    public Map<Agent, TicketOverride> getOverrides() {
        return overrides;
    }

    public Set<TripOption> getTripOptions() {
        return tripOptions;
    }

    public Set<Ticket> getTicketsForAgent(Agent agent) {
        if (overrides.containsKey(agent)) {
            Set<Ticket> agentOverrides = new HashSet<>(overrides.get(agent).getTickets());
            agentOverrides.addAll(tickets);
            return agentOverrides;
        }

        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public TripTemplate getTripTemplate() {
        return tripTemplate;
    }

    public void setTripTemplate(TripTemplate tripTemplate) {
        this.tripTemplate = tripTemplate;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }
}
