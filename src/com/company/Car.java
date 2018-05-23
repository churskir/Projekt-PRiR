package com.company;

public class Car implements Runnable{
    private Position position;
    private Thread thread = null;
    private String id;
    private Velocity velocity;

    public Car(String id, Position position) {
        this.position = position;
        this.id = id;
        this.velocity = new Velocity(500);
        this.run();
    }

    public void start() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Car " + id + " moves.");
                Thread.sleep(velocity.getTimePerField());
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Car " + id + " terminates on " + position.toString());
    }

    public void run() {
        if (thread == null) {
            thread = new Thread(this, "Car");
            start();
        }
    }

}
