package com.company;

public class Main {

    public static void main(String[] args) {
        Map map = new Map();
        Car car1 = new Car("1", new Position(1,0), map);
        Car car2 = new Car("2", new Position(0,2), map);
    }
}
