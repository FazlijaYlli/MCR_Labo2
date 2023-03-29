package ch.heig.renderers;

import ch.heig.bouncers.Bouncable;

import java.awt.*;

public class FilledBouncerRenderer implements Renderer{
    // On stocke l'instance pour ne jamais créer deux fois la même instance.
    private static FilledBouncerRenderer instance;

    private FilledBouncerRenderer() {}

    /**
     * @return l'instance unique du Singleton
     */
    public static FilledBouncerRenderer getInstance() {
        if (instance == null) { instance = new FilledBouncerRenderer(); }
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.fill(b.getShape());
    }
}
