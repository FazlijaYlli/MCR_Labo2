package ch.heig.renderers;

import ch.heig.bouncers.Bouncable;

import java.awt.*;

public interface Renderer {
    void display(Graphics2D g, Bouncable b);
}
