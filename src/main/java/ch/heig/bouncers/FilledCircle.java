package ch.heig.bouncers;

import ch.heig.renderers.FilledBouncerRenderer;

import java.awt.*;

public class FilledCircle extends Circle {
    private static final Color color = Color.BLUE;

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public FilledBouncerRenderer getRenderer() {
        return FilledBouncerRenderer.getInstance();
    }
}
