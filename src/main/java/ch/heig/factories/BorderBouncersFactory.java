package ch.heig.factories;

import ch.heig.bouncers.BorderCircle;
import ch.heig.bouncers.BorderSquare;
import ch.heig.bouncers.Circle;
import ch.heig.bouncers.Square;

public class BorderBouncersFactory implements BouncersFactory{
    private static BorderBouncersFactory instance;

    private BorderBouncersFactory() {}

    public static BorderBouncersFactory getInstance() {
        if (instance == null) { instance = new BorderBouncersFactory(); }
        return instance;
    }

    @Override
    public Square makeSquare() {
        return new BorderSquare();
    }

    @Override
    public Circle makeCircle() {
        return new BorderCircle();
    }
}
