package ch.heig.bouncers;

import ch.heig.displayers.FrameDisplayer;
import ch.heig.renderers.Renderer;
import ch.heig.vectors.Vector2D;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Bouncer implements Bouncable {
    private final int size;
    private final Vector2D movement;
    protected final Vector2D position;
    private static final int MAX_SIZE = 50;
    private static final int MIN_SIZE = 10;
    private static final int MAX_SPD = 10;
    private static final int MIN_SPD = -10;

    public Bouncer() {
        position = new Vector2D(
                ThreadLocalRandom.current().nextInt(FrameDisplayer.getInstance().getWidth()),
                ThreadLocalRandom.current().nextInt(FrameDisplayer.getInstance().getHeight())
        );
        movement = new Vector2D(
                ThreadLocalRandom.current().nextInt(MIN_SPD, MAX_SPD + 1),
                ThreadLocalRandom.current().nextInt(MIN_SPD, MAX_SPD + 1)
        );
        size = ThreadLocalRandom.current().nextInt(MIN_SIZE,MAX_SIZE+1);
    }

    @Override
    public void move() {
        FrameDisplayer frame = FrameDisplayer.getInstance();

        // Mouvement
        position.set(position.getX() + movement.getX(), position.getY() + movement.getY());

        /* Si on detecte que le prochain mouvement sera plus loin que les limites,
           On arrête le mouvement et on inverse la vitesse horizontale */

        // Collisions horizontale
        if (position.getX() >= frame.getWidth() - size - movement.getX() || position.getX() + movement.getX() <= 0) {
            position.setX(position.getX() + movement.getX() <= 0 ? 0 : frame.getWidth() - size);
            movement.setX(-movement.getX());
        }

        // Collision verticales
        if (position.getY() >= frame.getHeight() - size - movement.getY() || position.getY() + movement.getY() <= 0) {
            position.setY(position.getY() + movement.getY() <= 0 ? 0 : frame.getHeight()  - size);
            movement.setY(-movement.getY());
        }
    }

    @Override
    public void draw() {
        getRenderer().display(FrameDisplayer.getInstance().getGraphics(), this);
    }

    public int getSize() { return size; }

    public abstract Color getColor();
    public abstract Shape getShape();
    public abstract Renderer getRenderer();
}
