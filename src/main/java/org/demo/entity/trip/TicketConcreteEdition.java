package org.demo.entity.trip;

import org.demo.annotations.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class TicketConcreteEdition {

    private String name;

    private int from;

    private int to;

    private BigDecimal price;

    public TicketConcreteEdition(String name, int from, int to, BigDecimal price) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public TicketConcreteEdition() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketConcreteEdition that = (TicketConcreteEdition) o;

        if (from != that.from) return false;
        if (to != that.to) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(price != null ? !price.equals(that.price) : that.price != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + from;
        result = 31 * result + to;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
