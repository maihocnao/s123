package com.example.myapplication;

public class Event {
    private String eventName;
    private int imgScr;
    private String time;
    private String dayStart;
    private String dayEnd;
    private String location;
    private int checkedPeople;
    private int amountPeople;

    public Event() {
    }

    public Event(String eventName, int imgScr, String time, String dayStart, String dayEnd, String location, int checkedPeople, int amountPeople) {
        this.eventName = eventName;
        this.imgScr = imgScr;
        this.time = time;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.location = location;
        this.checkedPeople = checkedPeople;
        this.amountPeople = amountPeople;
    }

    //for current
    public Event(String eventName, int imgScr, String time, String location, int checkedPeople, int amountPeople) {
        this.eventName = eventName;
        this.imgScr = imgScr;
        this.time = time;
        this.location = location;
        this.checkedPeople = checkedPeople;
        this.amountPeople = amountPeople;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getImgScr() {
        return imgScr;
    }

    public void setImgScr(int imgScr) {
        this.imgScr = imgScr;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCheckedPeople() {
        return checkedPeople;
    }

    public void setCheckedPeople(int checkedPeople) {
        this.checkedPeople = checkedPeople;
    }

    public int getAmountPeople() {
        return amountPeople;
    }

    public void setAmountPeople(int amountPeople) {
        this.amountPeople = amountPeople;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }
}
