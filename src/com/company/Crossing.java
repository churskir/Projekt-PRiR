package com.company;

import static com.company.Color.*;

public class Crossing extends MapItem implements Runnable {

    private Thread thread;
    private Light light0;
    private Light light1;
    private int changeTime = 5000;

    public Crossing(Position position) {
        super(position);
        light0 = new Light(0, RED);
        light1 = new Light(1, GREEN);
        this.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                light0.change();
                light1.change();
                Thread.sleep(changeTime);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(toString() + " terminates.");
    }

    public void start() {
        if (thread == null) {
            thread = new Thread (this, "a");
            thread.start ();
        }
    }

    @Override
    public String toString() {
        return "Crossing at " + super.getPosition().toString();
    }
}
