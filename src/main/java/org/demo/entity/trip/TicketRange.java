package org.demo.entity.trip;


import java.math.BigDecimal;

public class TicketRange {

    protected int from;

    protected int to;

    protected BigDecimal price;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean contains(int count) {
        return count >= from && count <= to;
    }

}
