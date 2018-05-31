package com.company.Map;

import com.company.Position;

public class MapItem {
    private Position position;
    private MapItemType type;

    public MapItem(Position position, MapItemType type) {
        this.position = position;
        this.type = type;
    }

    public MapItemType getType() {
        return this.type;
    }

    public Position getPosition() {
        return this.position;
    }
}
