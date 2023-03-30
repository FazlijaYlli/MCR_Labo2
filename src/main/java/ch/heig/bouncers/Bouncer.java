package ch.heig.bouncers;

import ch.heig.displayers.FrameDisplayer;
import ch.heig.renderers.Renderer;
import ch.heig.vectors.Vector2D;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Bouncer implements Bouncable {
    protected int x;
    protected int y;
    private final int size;
    private final Vector2D movement;
    private static final int MAX_SIZE = 50;
    private static final int MIN_SIZE = 10;
    private static final int MAX_SPD = 10;
    private static final int MIN_SPD = -10;

    public Bouncer() {
        x = ThreadLocalRandom.current().nextInt(FrameDisplayer.getInstance().getWidth());
        y = ThreadLocalRandom.current().nextInt(FrameDisplayer.getInstance().getHeight());
        movement = new Vector2D(
                ThreadLocalRandom.current().nextInt(MIN_SPD, MAX_SPD),
                ThreadLocalRandom.current().nextInt(MIN_SPD, MAX_SPD)
        );
        size = ThreadLocalRandom.current().nextInt(MIN_SIZE,MAX_SIZE+1);
    }

    @Override
    public void move() {
        FrameDisplayer frame = FrameDisplayer.getInstance();
        int width = frame.getWidth();
        int height = frame.getHeight();

        x += movement.getX();
        y += movement.getY();

        // Collisions horizontale
        if (x >= width - size - movement.getX() || x <= 0) {
            // Si on est à "un mouvement" de distance de toucher le mur
            // On arrête le mouvement et on inverse la vitesse horizontale
            x = x <= 0 ? 0 : width - size;
            movement.setX(-movement.getX());
        }

        // Collision verticales
        if (y >= height - size - movement.getY() || y <= 0) {
            y = y <= 0 ? 0 : height - size;
            movement.setY(-movement.getY());
        }
    }

    @Override
    public void draw() {
        getRenderer().display(FrameDisplayer.getInstance().getGraphics(), this);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getSize() { return size; }

    public abstract Color getColor();
    public abstract Shape getShape();
    public abstract Renderer getRenderer();
}
