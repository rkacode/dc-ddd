package org.demo.entity.trip;

import org.demo.annotations.AggregateRoot;

import javax.persistence.ElementCollection;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@AggregateRoot
public class Ticket {

    protected int id;

    protected String name;

    @ElementCollection
    protected Set<TicketOption> options = new HashSet<TicketOption>();

    public BigDecimal getPriceForCount(int count) {
        for (TicketOption option : options) {
            if (option.contains(count)) {
                
            }
        }

    }

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

    public Set<TicketOption> getOptions() {
        return options;
    }

    public void setOptions(Set<TicketOption> options) {
        this.options = options;
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

}
