package ch.heig.graphics.renderers;

import ch.heig.bouncers.Bouncable;

import java.awt.Graphics2D;

/**
 * Renderer for filled bouncable objects specifically.
 *
 * @version 1.0 - 30.03.2023
 */
public class FilledBouncerRenderer implements Renderer {
    private static FilledBouncerRenderer instance;

    /**
     * Private constructor to prevent multiple instances.
     */
    private FilledBouncerRenderer() {
    }

    /**
     * Get the unique instance of a FilledBouncerRenderer singleton
     *
     * @return the unique instance of a FilledBouncerRenderer singleton
     */
    public static FilledBouncerRenderer getInstance() {
        if (instance == null) {
            instance = new FilledBouncerRenderer();
        }
        return instance;
    }

    /**
     * Draw the given bouncable object
     *
     * @param g The graphics context
     * @param b The bouncable to draw
     */
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.fill(b.getShape());
    }
}
