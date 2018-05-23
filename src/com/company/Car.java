package com.company;

public class Car implements Runnable{
    private Position position;
    private Position prevPosition;
    private Thread thread = null;
    private String id;
    private Velocity velocity;
    private Map map;

    public Car(String id, Position position, Map map) {
        this.position = new Position(1, 0);
        this.prevPosition = new Position(-1, -1);
        this.id = id;
        this.map = map;
        this.velocity = new Velocity(500);
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
            for (int i = 0; i < 5; i++) {
                move();
                Thread.sleep(velocity.getTimePerField());
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Car " + id + " terminates on " + position.toString());
    }

    public String toString() {
        return "Car " + id + " on " + position;
    }

    private void move() {
        MapItem[] surroundings = map.getSurroudings(position);
        for (int i = 0; i < surroundings.length; i++) {
            if (surroundings[i] != null)
                if (!surroundings[i].getPosition().equals(prevPosition)) {
                    prevPosition = position;
                    position = surroundings[i].getPosition();
                    printMove();
                    return;
                }
        }
    }

    private void printMove() {
        System.out.println("Car " + id + " moves from " + prevPosition.toString() + " to " + position.toString());
    }
}
