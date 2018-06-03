package com.company.Map;

import com.company.Position;

import java.util.ArrayList;

public class Map {
    private int width;
    private int height;
    private MapItem[][] worldsMap;
    private ArrayList<Crossing> crossings = new ArrayList<>();
    private ArrayList<Road> roads = new ArrayList<>();

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
        this.width = 3;
        this.height = 3;
    }

    public Map(int width, int height) {
        this.worldsMap = new MapItem[height][width];
        this.width = width;
        this.height = height;
    }

    public void setItem(int x, int y, MapItem mapItem) {
        assert (x < width);
        assert (y < height);
        this.worldsMap[y][x] = mapItem;
        if (mapItem != null) {
            if (mapItem.getType() == MapItemType.CROSSING)
                this.crossings.add((Crossing) mapItem);
            else if (mapItem.getType() == MapItemType.ROAD)
                this.roads.add((Road) mapItem);
        }
    }

    public MapItem getItem(Position position) {
        if (position.isInRange(width, height))
            return worldsMap[position.getY()][position.getX()];
        return null;
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

    public ArrayList<Crossing> getAllCrossings() {
        return this.crossings;
    }

    public ArrayList<Road> getallRoads() {
        return this.roads;
    }

    public String toString() {
        System.out.println(width + "x" + height);
        String out = "";
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (worldsMap[r][c] == null)
                    out += "  ";
                else {
                    switch (this.worldsMap[r][c].getType()) {
                        case ROAD: {
                            out += "R ";
                            break;
                        }
                        case CROSSING: {
                            out += "C ";
                            break;
                        }
                        default: {
                            out += "  ";
                            break;
                        }
                    }
                }
            }
            out += "\n";
        }
        return width + "x" + height + "\n" + out;
    }
}
