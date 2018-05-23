package com.company;

import static com.company.Color.*;

public class Light {
    private int id;
    private Color color;

    public Light(int id, Color color) {
        this.id = id;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void change() {
        if (color == RED)
            color = GREEN;
        else
            color = RED;
        System.out.println(toString());
    }

    public String toString() {
        return this.id + " has color " + this.color;
    }
}
