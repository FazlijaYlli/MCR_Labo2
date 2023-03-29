package ch.heig.factories;

import ch.heig.bouncers.Circle;
import ch.heig.bouncers.Square;

public interface BouncersFactory {
    Square makeSquare();
    Circle makeCircle();
}
