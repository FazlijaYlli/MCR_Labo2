package ch.heig.factories;

import ch.heig.bouncers.Circle;
import ch.heig.bouncers.FilledCircle;
import ch.heig.bouncers.FilledSquare;
import ch.heig.bouncers.Square;

public class FilledBouncersFactory implements BouncersFactory {
    private static FilledBouncersFactory instance;
    private FilledBouncersFactory() {}
    public static FilledBouncersFactory getInstance() {
        if (instance == null) { instance = new FilledBouncersFactory(); }
        return instance;
    }

    @Override
    public Square makeSquare() {
        return new FilledSquare();
    }

    @Override
    public Circle makeCircle() {
        return new FilledCircle();
    }
}
