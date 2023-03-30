package ch.heig.bouncers;

import ch.heig.renderers.BorderBouncerRenderer;

import java.awt.*;

public class BorderCircle extends Circle {
    private static final Color color = Color.GREEN;

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public BorderBouncerRenderer getRenderer() {
        return BorderBouncerRenderer.getInstance();
    }
}
