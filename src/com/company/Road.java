package com.company;

class Road extends MapItem{

    public Road(Position position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Road at " + super.getPosition().toString();
    }
}