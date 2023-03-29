package ch.heig.factories;

import ch.heig.bouncers.BorderSquare;
import ch.heig.bouncers.FilledSquare;
import ch.heig.bouncers.Square;

public class BorderBouncersFactory implements BouncersFactory{
    private static BorderBouncersFactory instance;
    private BorderBouncersFactory() {}

    public static BorderBouncersFactory getInstance() {
        if (instance == null) { instance = new BorderBouncersFactory(); }
        return instance;
    }

    @Override
    public Square createSquare() {
        return new BorderSquare();
    }
}
