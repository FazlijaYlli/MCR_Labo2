package ch.heig.bouncers;

import ch.heig.renderers.BorderBouncerRenderer;

import java.awt.*;

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
