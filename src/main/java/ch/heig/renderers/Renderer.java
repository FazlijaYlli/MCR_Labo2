package ch.heig.renderers;

import ch.heig.bouncers.Bouncable;

import java.awt.Graphics2D;

/**
 * Interface for classes that draw the bouncers.
 *
 * @version 1.0 - 20.03.2023
 */
public interface Renderer {
    /**
     * Draws the given bouncable object.
     *
     * @param g The graphics context.
     * @param b The bouncable to draw.
     */
    void display(Graphics2D g, Bouncable b);
}
