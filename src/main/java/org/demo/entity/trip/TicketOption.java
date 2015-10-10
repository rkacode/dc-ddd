package org.demo.entity.trip;


import org.demo.annotations.ValueObject;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@ValueObject
public class TicketOption {

    protected int fromCount;

    protected int toCount;

    protected BigDecimal price;

    /**
     * provision for agent
     */
    protected BigDecimal markup;

    public TicketOption(TicketOption option) {
        this.fromCount = option.fromCount;
        this.toCount = option.toCount;
        this.price = option.price;
        this.markup = option.markup;
    }

    public TicketOption() {
    }

    public int getFromCount() {
        return fromCount;
    }

    public void setFromCount(int from) {
        this.fromCount = from;
    }

    public int getToCount() {
        return toCount;
    }

    public void setToCount(int to) {
        this.toCount = to;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean contains(int count) {
        return count >= fromCount && count <= toCount;
    }

    public BigDecimal getMarkup() {
        return markup;
    }

    public void setMarkup(BigDecimal markup) {
        this.markup = markup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketOption that = (TicketOption) o;

        if (fromCount != that.fromCount) return false;
        if (toCount != that.toCount) return false;
        if (markup != null ? !markup.equals(that.markup) : that.markup != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fromCount;
        result = 31 * result + toCount;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (markup != null ? markup.hashCode() : 0);
        return result;
    }
}
