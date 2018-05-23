package com.company;

public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public boolean isInRange(int width, int height) {
        if (!isPositive())
            return false;
        return ((x < width) && (y < height));
    }

    public boolean isPositive() {
        return x >= 0 && y >= 0;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
