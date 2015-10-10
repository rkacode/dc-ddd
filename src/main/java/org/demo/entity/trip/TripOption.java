package org.demo.entity.trip;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trip_option")
public class TripOption {

    @Id
    @GeneratedValue
    private int id;

    private String language;

    private String hour;

    private LocalDate fromDate;

    private LocalDate toDate;

    private DayOfWeek weekDay;

    private int maxSeats;

    @ElementCollection
    @CollectionTable(name = "free_day")
    private Set<LocalDate> freeDays = new HashSet<>();

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public DayOfWeek getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(DayOfWeek weekDay) {
        this.weekDay = weekDay;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate to) {
        this.toDate = to;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate from) {
        this.fromDate = from;
    }

    public Set<LocalDate> getFreeDays() {
        return freeDays;
    }

    public void setFreeDays(Set<LocalDate> freeDays) {
        this.freeDays = freeDays;
    }
}
