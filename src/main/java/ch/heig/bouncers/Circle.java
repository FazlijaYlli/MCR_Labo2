package ch.heig.bouncers;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public abstract class Circle extends Bouncer {
    @Override
    public Ellipse2D.Double getShape() {
        // Création des données concernant le rectangle.
        return new Ellipse2D.Double(getX(),getY(), getSize(), getSize());
    }
}
