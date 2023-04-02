package ch.heig.displayers;

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;

/**
 * Frame displayer that uses a JFrame to display the game and allows to use the
 * keyboard.
 *
 * @version 1.0 - 30.03.2023
 */
public class FrameDisplayer implements Displayer {
    private static FrameDisplayer instance;
    private static final JFrame frame = new JFrame();
    private final Container panel;
    private Image image;
    private static final int BASE_W = 640;
    private static final int BASE_H = 480;

    /**
     * Private constructor to prevent multiple instances.
     */
    private FrameDisplayer() {
        frame.setSize(BASE_W, BASE_H);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = frame.getContentPane();
        panel.setBackground(Color.WHITE);
        image = panel.createImage(getWidth(), getHeight());
        frame.addComponentListener(new ComponentAdapter() {
            // The program throws an exception if the height of the image = 0,
            // so we block it to 1.
            @Override
            public void componentResized(ComponentEvent e) {
                image = panel.createImage(
                        getWidth(), (getHeight() == 0 ? 1 : getHeight())
                );
            }
        });
        frame.setVisible(true);
    }

    /**
     * Get the unique instance of a FrameDisplayer singleton
     *
     * @return the unique instance of a FrameDisplayer singleton
     */
    public static FrameDisplayer getInstance() {
        if (instance == null) {
            instance = new FrameDisplayer();
        }
        return instance;
    }

    /**
     * Get the width of the displayer.
     *
     * @return The width of the displayer.
     */
    @Override
    public int getWidth() {
        return panel.getWidth();
    }

    /**
     * Get the height of the displayer.
     *
     * @return The height of the displayer.
     */
    @Override
    public int getHeight() {
        return panel.getHeight();
    }

    /**
     * Get the graphics context of the displayer.
     *
     * @return The graphics context of the displayer.
     */
    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) image.getGraphics();
    }

    /**
     * Repaint the displayer and clear the graphics context.
     */
    @Override
    public void repaint() {
        panel.getGraphics().drawImage(image, 0, 0, null);
        Graphics2D g = getGraphics();
        // Empty the graphics 2D object.
        g.clearRect(0, 0, getWidth(), getHeight());
        // Use the drawImage method to recreate an empty image.
    }

    /**
     * Set the title of the displayer.
     *
     * @param title The title of the displayer.
     */
    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }

    /**
     * Add a key listener to the displayer.
     *
     * @param ka The key adapter to add.
     */
    @Override
    public void addKeyListener(KeyAdapter ka) {
        frame.addKeyListener(ka);
    }
}
