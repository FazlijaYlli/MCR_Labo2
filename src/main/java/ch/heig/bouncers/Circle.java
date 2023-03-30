package ch.heig.bouncers;

import java.awt.geom.Ellipse2D;

public abstract class Circle extends Bouncer {
    public Ellipse2D.Double getShape() {
        // Création des données concernant le rectangle.
        return new Ellipse2D.Double(position.getX(), position.getY(), getSize(), getSize());
    }
}
