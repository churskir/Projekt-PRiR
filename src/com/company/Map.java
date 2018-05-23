package com.company;

class Road extends MapItem{
    private Position position;

    public Road(Position position) {
        this.position = position;
    }

    @Override
    public MapItemType getType() {
        return MapItemType.ROAD;
    }
}

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

    public MapItem getRegion(Position position) {
        if (position.isInRange(width, height))
            return worldsMap[position.x][position.y];
        return null;
    }
}
