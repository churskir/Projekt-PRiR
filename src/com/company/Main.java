package com.company;

import com.company.Map.Crossing;
import com.company.Map.Map;
import com.company.Map.MapReader;
import com.company.Map.Road;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static ArrayList<Car> cars = new ArrayList<>();
    private static int minVelocity = 500;
    private static int maxVelocity = 1500;

    private static void printUsage() {
        System.out.println("Usage:\n[map file path] [number of cars] [time in seconds to terminate]");
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            printUsage();
            return;
        }
        Map map = MapReader.readMap(args[0]);
        if (map == null) {
            System.out.println("It failed to read the map file.");
            printUsage();
            return;
        }

        System.out.println(map.toString());

        int numCars = Integer.parseInt(args[1]);
        ArrayList<Road> roads = map.getallRoads();
        Random random = new Random();

        for (int i = 0; i < numCars; i++) {
            cars.add(new Car(
                i,
                roads.get(random.nextInt(roads.size())).getPosition(),
                new Velocity(random.nextInt(maxVelocity - minVelocity) + minVelocity),
                map)
            );
        }

        try {
            Thread.sleep(1000 * Integer.parseInt(args[2]));
        } catch (InterruptedException e) {
            System.out.println("Program was interrupted");
        }

        for (int i = 0; i < numCars; i++)
            cars.get(i).stop();

        ArrayList<Crossing> crossings = map.getAllCrossings();
        for (int i = 0; i < crossings.size(); i++)
            crossings.get(i).stop();
    }
}
