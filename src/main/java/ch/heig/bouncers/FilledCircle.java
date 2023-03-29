package ch.heig.bouncers;

import ch.heig.renderers.FilledBouncerRenderer;

import java.awt.*;

public class FilledCircle extends Circle {
    @Override
    public Color getColor() {
        return Color.BLUE;
    }

    @Override
    public FilledBouncerRenderer getRenderer() {
        return FilledBouncerRenderer.getInstance();
    }
}
