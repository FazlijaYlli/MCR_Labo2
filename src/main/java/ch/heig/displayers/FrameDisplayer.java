package ch.heig.displayers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;

public class FrameDisplayer implements Displayer {
    private static FrameDisplayer instance;
    private final JPanel panel;
    public final JFrame frame;
    private Image image;
    private static final int BASE_W = 640;
    private static final int BASE_H = 480;

    private FrameDisplayer() {
        frame = new JFrame();
        frame.setSize(BASE_W, BASE_H);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        frame.setContentPane(panel);

        frame.setVisible(true);
        image = panel.createImage(getWidth(), getHeight());
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                image = panel.createImage(getWidth(), getHeight());
            }
        });
    }

    public static FrameDisplayer getInstance() {
        if (instance == null) { instance = new FrameDisplayer(); }
        return instance;
    }

    @Override
    public int getWidth() {
        return panel.getWidth();
    }

    @Override
    public int getHeight() {
        return panel.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) image.getGraphics();
    }

    @Override
    public void repaint() {
        // Utilisation de la méthode drawImage pour recrer une image vide.
        panel.getGraphics().drawImage(image, 0, 0, null);
        Graphics2D g = getGraphics();
        // Vidage l'objet graphics 2D.
        g.clearRect(0, 0, getWidth(), getHeight());
        g.dispose();
    }

    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }

    @Override
    public void addKeyListener(KeyAdapter ka) {
        frame.addKeyListener(ka);
    }
}
