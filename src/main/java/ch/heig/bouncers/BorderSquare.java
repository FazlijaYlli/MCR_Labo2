package ch.heig.bouncers;

import ch.heig.graphics.renderers.BorderBouncerRenderer;

import java.awt.Color;

/**
 * Bordered square bouncer
 *
 * @version 1.0 - 30.03.2023
 */
public class BorderSquare extends Square {
    private static final Color color = Color.RED;

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public BorderBouncerRenderer getRenderer() {
        return BorderBouncerRenderer.getInstance();
    }
}
