package com.company.Map;

import com.company.Position;

import static com.company.Map.MapItemType.*;

public class Road extends MapItem {

    public Road(Position position) {
        super(position, ROAD);
    }

    @Override
    public String toString() {
        return "Road at " + super.getPosition().toString();
    }
}