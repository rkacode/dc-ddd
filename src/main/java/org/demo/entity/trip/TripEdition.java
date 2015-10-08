package org.demo.entity.trip;

import org.demo.entity.roles.Agent;

import java.util.*;

public class TripEdition {

    private TripTemplate tripTemplate;

    private Map<Agent, Set<Ticket>> overrides = new HashMap<Agent, Set<Ticket>>();

    private Set<Ticket> tickets = new HashSet<Ticket>();

    private Set<TripOption> tripOptions = new HashSet<TripOption>();

    public Map<Agent, Set<Ticket>> getOverrides() {
        return overrides;
    }

    public Set<TripOption> getTripOptions() {
        return tripOptions;
    }

    public Set<Ticket> getTicketsForAgent(Agent agent) {
        if (overrides.containsKey(agent)) {
            Set<Ticket> agentOverrides = new HashSet<>(overrides.get(agent));
            agentOverrides.addAll(tickets);
            return agentOverrides;
        }

        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
