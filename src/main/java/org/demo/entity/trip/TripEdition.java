package org.demo.entity.trip;

import org.demo.entity.roles.Agent;

import java.util.*;

public class TripEdition {

    private Map<Agent, Set<Ticket>> overrides = new HashMap<Agent, Set<Ticket>>();

    private Set<Ticket> tickets = new HashSet<Ticket>();

    private Set<TripOption> tripOptions = new HashSet<TripOption>();

    private Set<TripConcreteEdition> concreteTripEditions = new HashSet<TripConcreteEdition>();

    public Map<Agent, Set<Ticket>> getOverrides() {
        return overrides;
    }

    public void setOverrides(Map<Agent, Set<Ticket>> overrides) {
        this.overrides = overrides;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Set<TripOption> getTripOptions() {
        return tripOptions;
    }

    public void setTripOptions(Set<TripOption> tripOptions) {
        this.tripOptions = tripOptions;
    }

    public Set<TripConcreteEdition> getConcreteTripEditions() {
        return concreteTripEditions;
    }

    public void setConcreteTripEditions(Set<TripConcreteEdition> concreteTripEditions) {
        this.concreteTripEditions = concreteTripEditions;
    }

    public Set<TicketConcreteEdition> getTicketsForAgent(Agent agent) {
        return generateConcreteTickets(agent);
    }

    private Set<TicketConcreteEdition> generateConcreteTickets(Agent agent) {
        Set<TicketConcreteEdition> ticketConcreteEditions = new HashSet<TicketConcreteEdition>();

        for (Ticket ticket : tickets) {
            if (isOverriddenForAgent(ticket, agent)) {
                Ticket t = getOverriddenTicket(ticket, agent);
                Set<TicketConcreteEdition> concreteEditions = t.generateConreteTickets();
                ticketConcreteEditions.addAll(concreteEditions);
            }
        }

        return ticketConcreteEditions;
    }

    private boolean isOverriddenForAgent(Ticket ticket, Agent agent) {
        if (!overrides.containsKey(agent)) {
            return false;
        }

        Set<Ticket> tickets = overrides.get(agent);
        return tickets.contains(ticket);
    }

    private Ticket getOverriddenTicket(Ticket ticket, Agent agent) {
        Set<Ticket> tickets = overrides.get(agent);
        for (Ticket t : tickets) {
            if (t.equals(ticket)) {
                return t;
            }
        }

        throw new RuntimeException("No ticket override available");
    }

}
