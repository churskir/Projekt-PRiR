package com.company;

enum MapItemType {
    CROSSING, ROAD
}

public abstract class MapItem {
    public abstract MapItemType getType();
}
