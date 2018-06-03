package com.company;

import com.company.Map.Color;
import com.company.Map.Crossing;
import com.company.Map.Map;
import com.company.Map.MapItem;

import java.util.ArrayList;
import java.util.Random;

import static com.company.Map.Color.*;

public class Car implements Runnable{
    private Position position;
    private Position prevPosition = null;
    private Thread thread = null;
    private int id;
    private Velocity velocity;
    private Map map;
    private Random random = new Random();
    private boolean stop = false;

    public Car(int id, Position position, Velocity velocity, Map map) {
        this.position = position;
        this.id = id;
        this.map = map;
        this.velocity = velocity;
        this.constructorPrint();
        this.start();
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, "Car " + id);
            thread.start();
        }
    }

    public void run() {
        try {
            while (!stop) {
                move();
                Thread.sleep(velocity.getTimePerField());
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Car " + id + " terminates on " + position.toString());
    }

    public void stop() {
        this.stop = true;
    }

    public String toString() {
        return "Car " + id + " on " + position;
    }

    private void constructorPrint() {
        System.out.println(toString() + " with velocity " + velocity.toString() + " was created.");
    }

    private void move() {
        MapItem[] surroundings = map.getSurroudings(position);
        ArrayList<MapItem> goable = new ArrayList<>();
        for (int i = 0; i < surroundings.length; i++) {
            if (surroundings[i] != null) {
                if (this.prevPosition == null)
                    goable.add(surroundings[i]);
                else if (!surroundings[i].getPosition().equals(this.prevPosition))
                    goable.add(surroundings[i]);
            }
        }
        if (goable.size() == 0) {
            System.out.println("[APP]" + toString() + " has no way to go.");
            return;
        }
        MapItem nexItem = goable.get(random.nextInt(goable.size()));
        switch (nexItem.getType()) {
            case ROAD: {
                moveToPosition(nexItem.getPosition());
                break;
            }
            case CROSSING: {
                moveToCrossing((Crossing) nexItem);
                break;
            }
        }
    }

    private void moveToPosition(Position newPosition) {
        prevPosition = position;
        position = newPosition;
        printMove();
    }

    private void moveToCrossing(Crossing crossing) {
        Color color = crossing.getColor(this.position);
        System.out.println(this.toString() + " met light " + color);
        while ((color == RED) && (!stop)) {
            try {
                System.out.println(this.toString() + " waits for green light.");
                Thread.sleep(1000);
                color = crossing.getColor(this.position);
            } catch (InterruptedException e) {
                System.out.println("[APP] Waiting for green light interrupted.");
            }
        }
        moveToPosition(crossing.getPosition());
    }

    private void printMove() {
        System.out.println("Car " + id + " moves from " + prevPosition.toString() + " to " + position.toString());
    }
}
