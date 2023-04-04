package ch.heig.graphics.displayers;

import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;

/**
 * Interface for a displayer frame.
 *
 * @version 1.0 - 30.03.2023
 */
public interface Displayer {
    /**
     * Get the graphics context of the displayer.
     *
     * @return The graphics context of the displayer.
     */
    Graphics2D getGraphics();

    /**
     * Repaint the displayer.
     */
    void repaint();

    /**
     * Set the title of the displayer.
     *
     * @param title The title of the displayer.
     */
    void setTitle(String title);

    void addKeyListener(KeyAdapter ka);

    int getWidth();

    int getHeight();
}
