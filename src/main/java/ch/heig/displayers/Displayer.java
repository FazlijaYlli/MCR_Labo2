package ch.heig.displayers;

import java.awt.*;
import java.awt.event.KeyAdapter;

public interface Displayer {
    Graphics2D getGraphics();
    void repaint();
    void setTitle(String title);
    void addKeyListener(KeyAdapter ka);
    int getWidth();
    int getHeight();
}
