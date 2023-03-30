package ch.heig.renderers;

import ch.heig.bouncers.Bouncable;

import java.awt.Graphics2D;
import java.awt.BasicStroke;

/**
 * Renderer for bordered bouncable objects specifically.
 *
 * @version 1.0 - 30.03.2023
 */
public class BorderBouncerRenderer implements Renderer {
    private static BorderBouncerRenderer instance;
    private static final BasicStroke stroke = new BasicStroke(3);

    /**
     * Singleton: private constructor
     */
    private BorderBouncerRenderer() {
    }

    /**
     * Get the unique instance of the singleton
     *
     * @return the unique instance of the singleton
     */
    public static BorderBouncerRenderer getInstance() {
        if (instance == null) {
            instance = new BorderBouncerRenderer();
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
        g.setStroke(stroke);
        g.draw(b.getShape());
    }
}
