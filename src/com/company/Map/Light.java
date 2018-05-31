package com.company.Map;

import com.company.Axis;
import com.company.Map.Color;

import static com.company.Map.Color.*;

public class Light {
    private String id;
    private Color color;
    private Axis axis;

    public Light(String id, Color color, Axis axis) {
        this.id = id;
        this.color = color;
        this.axis = axis;
    }

    public Color getColor() {
        return color;
    }

    public void change() {
        if (color == RED)
            color = GREEN;
        else
            color = RED;
        //System.out.println(toString());
    }

    public String toString() {
        return this.id + " has color " + this.color;
    }
}
