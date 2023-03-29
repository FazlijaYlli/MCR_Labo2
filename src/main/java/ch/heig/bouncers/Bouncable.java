package ch.heig.bouncers;

import java.awt.*;

public interface Bouncable {
    void draw();
    void move();
    Color getColor();
    Shape getShape();
}
