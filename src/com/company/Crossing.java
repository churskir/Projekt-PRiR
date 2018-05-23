package com.company;

import static com.company.Color.*;

public class Crossing extends MapItem implements Runnable {

    private Position position;
    private Thread thread;
    private Light light0;
    private Light light1;
    private int changeTime = 5000;

    public Crossing(Position position) {
        this.position = position;
        light0 = new Light(0, RED);
        light1 = new Light(1, GREEN);
        this.start();
    }

    @Override
    public MapItemType getType() {
        return MapItemType.CROSSING;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                light0.change();
                light1.change();
                Thread.sleep(changeTime);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Crossing at " + position.toString() + " terminates.");
    }

    public void start() {
        if (thread == null) {
            thread = new Thread (this, "a");
            thread.start ();
        }
    }
}
