package ch.heig.renderers;

import ch.heig.bouncers.Bouncable;

import java.awt.*;

public class BorderBouncerRenderer implements Renderer{
    // On stocke l'instance pour ne jamais créer deux fois la même instance.
    private static BorderBouncerRenderer instance;
    private static final BasicStroke stroke = new BasicStroke(3);

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
        g.setStroke(stroke);
        g.draw(b.getShape());
    }
}
