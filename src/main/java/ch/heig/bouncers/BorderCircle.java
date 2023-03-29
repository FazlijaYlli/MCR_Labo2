package ch.heig.bouncers;

import ch.heig.renderers.BorderBouncerRenderer;

import java.awt.*;

public class BorderCircle extends Circle {
    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    @Override
    public BorderBouncerRenderer getRenderer() {
        return BorderBouncerRenderer.getInstance();
    }
}
