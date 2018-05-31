package com.company.Map;

import com.company.Axis;
import com.company.Position;

import static com.company.Axis.*;
import static com.company.Map.Color.*;

public class Crossing extends MapItem implements Runnable {

    private Thread thread;
    private Light lightX;
    private Light lightY;
    private int changeTime = 5000;
    private  boolean stop = false;

    public Crossing(Position position) {
        super(position, MapItemType.CROSSING);
        lightX = new Light("X", RED, X);
        lightY = new Light("Y", GREEN, Y);
        this.start();
    }

    public void run() {
        try {
            while (!stop) {
                lightX.change();
                lightY.change();
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

    public void stop() {
        this.stop = true;
    }

    public Color getColor(Position position) {
        Axis commonAxis = this.getPosition().getCommonAxis(position);
        if (commonAxis == X)
            return lightX.getColor();
        return lightY.getColor();
    }

    @Override
    public String toString() {
        return "Crossing at " + super.getPosition().toString();
    }
}
