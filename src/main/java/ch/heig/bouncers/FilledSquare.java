package ch.heig.bouncers;

import ch.heig.renderers.FilledBouncerRenderer;

import java.awt.Color;

/**
 * Filled square bouncer
 *
 * @version 1.0 - 30.03.2023
 */
public class FilledSquare extends Square {
    private static final Color color = Color.ORANGE;

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public FilledBouncerRenderer getRenderer() {
        return FilledBouncerRenderer.getInstance();
    }
}
