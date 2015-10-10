package org.demo.entity.trip;

import org.demo.annotations.AggregateRoot;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@AggregateRoot
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue
    protected int id;

    protected String name;

    @ElementCollection
    @CollectionTable(name = "ticket_options")
    protected Set<TicketOption> options = new HashSet<TicketOption>();

    public Ticket(String name) {
        this.name = name;
    }

    public Ticket() {
    }

    public BigDecimal calculatePrice(int count) {
        for (TicketOption option : options) {
            if (option.contains(count)) {
                return option.getPrice().multiply(BigDecimal.valueOf(count));
            }
        }

        throw new RuntimeException("No price available for count: " + count);
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

        if (name != null ? !name.equals(ticket.name) : ticket.name != null) return false;
        if (options != null ? !options.equals(ticket.options) : ticket.options != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (options != null ? options.hashCode() : 0);
        return result;
    }
}
