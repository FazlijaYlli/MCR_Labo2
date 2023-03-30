package ch.heig.bouncers;

import ch.heig.renderers.FilledBouncerRenderer;

import java.awt.*;

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
