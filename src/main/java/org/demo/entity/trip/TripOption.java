package org.demo.entity.trip;

import java.util.Set;

public class TripOption {

    private String language;

    private String hour;

    private String dateFrom;

    private String dateTo;

    private String weekdDay;

    private int maxSeats;

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

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getWeekdDay() {
        return weekdDay;
    }

    public void setWeekdDay(String weekdDay) {
        this.weekdDay = weekdDay;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }
}
