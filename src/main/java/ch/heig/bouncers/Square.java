package ch.heig.bouncers;

import java.awt.geom.Rectangle2D;

public abstract class Square extends Bouncer {
    @Override
    public Rectangle2D.Double getShape() {
        return new Rectangle2D.Double(getX(), getY(), getSize(), getSize());
    }
}
