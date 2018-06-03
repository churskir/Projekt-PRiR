package com.company;

public class Velocity {
    private int timePerField;

    public Velocity(int timePerField) {
        this.timePerField = timePerField;
    }

    public int getTimePerField() {
        return timePerField;
    }

    public String toString() {
        return "" + (timePerField / 1000.) + " f/s";
    }
}
