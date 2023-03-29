package ch.heig.bouncers;

import ch.heig.renderers.FilledBouncerRenderer;

import java.awt.*;

public class FilledSquare extends Square {
    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    @Override
    public FilledBouncerRenderer getRenderer() {
        return FilledBouncerRenderer.getInstance();
    }
}
