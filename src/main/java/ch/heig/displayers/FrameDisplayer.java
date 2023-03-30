package ch.heig.displayers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;

public class FrameDisplayer implements Displayer {
    private static FrameDisplayer instance;
    public static final JFrame frame = new JFrame();
    private final Container panel;
    private Image image;
    private static final int BASE_W = 640;
    private static final int BASE_H = 480;

    private FrameDisplayer() {
        frame.setSize(BASE_W, BASE_H);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = frame.getContentPane();
        panel.setBackground(Color.WHITE);
        image = panel.createImage(getWidth(), getHeight());
        frame.addComponentListener(new ComponentAdapter() {
            // Le programme lance une exception si la hauteure de l'image = 0, donc on la bloque à 1.
            @Override
            public void componentResized(ComponentEvent e) {
                image = panel.createImage(getWidth(), (getHeight() == 0 ? 1 : getHeight()));
            }
        });
        frame.setVisible(true);
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
        // Utilisation de la méthode drawImage pour recréer une image vide.
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
