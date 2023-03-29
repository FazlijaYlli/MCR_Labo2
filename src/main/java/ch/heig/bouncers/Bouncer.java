package ch.heig.bouncers;

import ch.heig.displayers.FrameDisplayer;
import ch.heig.renderers.Renderer;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Bouncer implements Bouncable {
    private final int size;
    private int x;
    private int y;
    private int mx;
    private int my;

    private static final int MAX_SIZE = 30;
    private static final int MIN_SIZE = 8;
    private static final int MAX_SPD = 8;
    private static final int MIN_SPD = -7;

    public Bouncer() {
        x = ThreadLocalRandom.current().nextInt(FrameDisplayer.getInstance().getWidth());
        y = ThreadLocalRandom.current().nextInt(FrameDisplayer.getInstance().getHeight());
        mx = ThreadLocalRandom.current().nextInt(MIN_SPD, MAX_SPD);
        my = ThreadLocalRandom.current().nextInt(MIN_SPD, MAX_SPD);
        size = ThreadLocalRandom.current().nextInt(MIN_SIZE,MAX_SIZE+1);
    }

    @Override
    public void move() {
        FrameDisplayer frame = FrameDisplayer.getInstance();
        int width = frame.getWidth();
        int height = frame.getHeight();

        x += mx;
        y += my;

        // Collisions horizontale
        if (x >= width - size || x <= 0) {
            x = x <= 0 ? 0 : width - size;
            mx = -mx;
        }

        // Collision verticales
        if (y >= height - size || y <= 0) {
            y = y <= 0 ? 0 : height - size;
            my = -my;
        }
    }

    @Override
    public void draw() {
        getRenderer().display(FrameDisplayer.getInstance().getGraphics(), this);
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public int getSize() {
        return size;
    }

    public abstract Color getColor();
    public abstract Shape getShape();

    public abstract Renderer getRenderer();
}
