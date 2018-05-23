package com.company;

enum MapItemType {
    CROSSING, ROAD
}

class MapItem {
    private Position position;
    private MapItemType type;

    public MapItem(Position position) {
        this.position = position;
    }

    public MapItemType getType() {
        return this.type;
    }

    public Position getPosition() {
        return this.position;
    }
}
