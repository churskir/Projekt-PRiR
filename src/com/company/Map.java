package com.company;

public class Map {
    private int width = 3;
    private int height = 3;
    private MapItem[][] worldsMap;

    public Map() {
        this.worldsMap = new MapItem[][] {
            {
                null,
                new Road(new Position(1, 0)),
                new Road(new Position(2, 0))
            },
            {
                new Road(new Position(0, 1)),
                new Crossing(new Position(1, 1)),
                new Road(new Position(1, 2))
            },
            {
                new Road(new Position(2, 0)),
                new Road(new Position(2, 1)),
                null}
        };
    }

    // Return all MapItems around the position
    public MapItem[] getSurroudings(Position position) {
        Position[] positionsSurroundings = position.getSurroundings();
        MapItem[] surroundings = new MapItem[positionsSurroundings.length];
        int surIndex = 0;
        for (int i = 0; i < positionsSurroundings.length; i++)
            surroundings[surIndex++] = getItem(positionsSurroundings[i]);
        return surroundings;
    }

    public MapItem getItem(Position position) {
        if (position.isInRange(width, height))
            return worldsMap[position.x][position.y];
        return null;
    }
}
