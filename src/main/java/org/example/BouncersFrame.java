package org.example;

import javax.swing.*;
import java.awt.*;

public class BouncersFrame extends JFrame implements Displayer{
    private static BouncersFrame instance = null;
    private final int width;
    private final int height;

    private BouncersFrame(int width, int height) {
        this.width = width;
        this.height = height;
        setTitle("Bouncers");
        setResizable(true);
    }

    public static BouncersFrame getInstance(int width, int height) {
        if (instance == null) {
            instance = new BouncersFrame(width, height);
        }
        return instance;
    }

    /**
     * Display the frame
     */
    public void display() {
        pack();
        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void drawRectangles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

//        g2d.drawRect(30, 50, 420, 120);

        // TODO: ça ça marche pas
//        JPanel panel = new JPanel();
//        Image offscreenImage = panel.createImage(width, height);
//        Graphics2D graphics = (Graphics2D) offscreenImage.getGraphics();
//        graphics.fillRect(0, 0, width, height);

    }

    void paintComponent(Graphics g) { // TODO
        super.paint(g);
        drawRectangles(g);
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawRectangles(g);
    }

//    public void displayImage() {
//        class DisplayGraphics extends JPanel {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                g.fillRect(0, 0, getWidth(), getHeight());
////                createImage(width, height).getGraphics().fillRect(0, 0, width, height);
//            }
//        }
//
//        DisplayGraphics panel = new DisplayGraphics();
//        panel.add(new JLabel("Hello?"));
//        panel.paintComponent(getGraphics());
////        repaint();
////        revalidate();
//
////        panel.createImage(width, height).getGraphics().fillRect(0, 0, width, height);
//
////        Image offscreenImage = panel.createImage(width, height);
////        Graphics2D graphics = (Graphics2D) offscreenImage.getGraphics();
////        graphics.fillRect(0, 0, width, height);
//
//
//        // set up and display the frame
////        getContentPane().add(panel);
//
//        display();
//    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) super.getGraphics();
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }
}
