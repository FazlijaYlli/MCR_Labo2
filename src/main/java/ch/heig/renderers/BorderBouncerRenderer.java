package ch.heig.renderers;

import ch.heig.bouncers.Bouncable;

import java.awt.*;

public class BorderBouncerRenderer implements Renderer{
    // On stocke l'instance pour ne jamais créer deux fois la même instance.
    private static BorderBouncerRenderer instance;

    private BorderBouncerRenderer() {}

    /**
     * @return l'instance unique du Singleton
     */
    public static BorderBouncerRenderer getInstance() {
        if (instance == null) { instance = new BorderBouncerRenderer(); }
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.setStroke(new BasicStroke(3));
        g.draw(b.getShape());
    }
}
