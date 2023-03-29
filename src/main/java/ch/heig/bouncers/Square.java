package ch.heig.bouncers;

import java.awt.geom.Rectangle2D;

/**
 * Classe représentant un carré de manière abstraite.
 * Elle contient les informations nécéssaires aux carrés pleins et vides.
 */
public abstract class Square extends Bouncer {
    @Override
    public Rectangle2D.Double getShape() {
        // Création des données concernant le rectangle.
        return new Rectangle2D.Double(getX(), getY(), getSize(), getSize());
    }
}
