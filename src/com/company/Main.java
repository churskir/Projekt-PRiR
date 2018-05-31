package com.company;

import com.company.Map.Crossing;
import com.company.Map.Map;
import com.company.Map.MapReader;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Map mapB = MapReader.readMap("C:\\Users\\rchur\\IdeaProjects\\Projekt PRiR\\src\\com\\company\\example_map.txt");
        //Map map = new Map();
        System.out.println(mapB.toString());
        Car car1 = new Car("1", new Position(3,0), new Velocity(500), mapB);
        Car car2 = new Car("2", new Position(0,2), new Velocity(1000), mapB);
        try {
            Thread.sleep(10 * 1000);
        } catch (Exception e) {
        }
        car1.stop();
        car2.stop();
        ArrayList<Crossing> crossings = mapB.getAllCrossings();
        for (int i = 0; i < crossings.size(); i++)
            crossings.get(i).stop();
    }
}
