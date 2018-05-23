package com.company;

import java.util.Objects;

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

    public Position[] getSurroundings() {
        return new Position[]{
            new Position(x + 1, y),
            new Position(x, y + 1),
            new Position(x - 1, y),
            new Position(x, y - 1)
        };
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
            y == position.y;
    }
}
