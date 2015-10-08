package org.demo.entity.trip;

import org.demo.annotations.AggregateRoot;

import java.util.HashSet;
import java.util.Set;

@AggregateRoot
public class Ticket {

    protected int id;

    protected String name;

    protected Set<TicketRange> rangeSet = new HashSet<TicketRange>();

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

    public Set<TicketRange> getRangeSet() {
        return rangeSet;
    }

    public void setRangeSet(Set<TicketRange> rangeSet) {
        this.rangeSet = rangeSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        return !(name != null ? !name.equals(ticket.name) : ticket.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }


    public Set<TicketConcreteEdition> generateConreteTickets() {
        Set<TicketConcreteEdition> ticketConcreteEditions = new HashSet<TicketConcreteEdition>();

        for (TicketRange ticketRange : rangeSet) {
            ticketConcreteEditions.add(new TicketConcreteEdition(name, ticketRange.from, ticketRange.to, ticketRange.price));
        }

        return ticketConcreteEditions;
    }
}
