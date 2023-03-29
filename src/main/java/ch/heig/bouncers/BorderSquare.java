package ch.heig.bouncers;

import ch.heig.renderers.BorderBouncerRenderer;

import java.awt.*;

public class BorderSquare extends Square {
    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public BorderBouncerRenderer getRenderer() {
        return BorderBouncerRenderer.getInstance();
    }
}
