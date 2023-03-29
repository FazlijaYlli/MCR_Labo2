package ch.heig.renderers;

import javax.swing.*;
import java.awt.*;

public class BouncersFrame extends JFrame implements Displayer {
    private static BouncersFrame instance = null;
    private final int bouncerFrameWidth;
    private final int bouncerFrameHeight;

    private BouncersFrame(int width, int height) {
        this.bouncerFrameWidth = width;
        this.bouncerFrameHeight = height;
        setTitle("Bouncers");
        getContentPane().setBackground(Color.BLACK);
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
        setSize(bouncerFrameWidth, bouncerFrameHeight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void drawRectangles(Graphics g) {
        Image offscreenImage = createImage(bouncerFrameWidth, bouncerFrameHeight);
        Graphics2D graphics = (Graphics2D) offscreenImage.getGraphics();
        graphics.setColor(Color.WHITE);
//        graphics.setPaintMode();
//        graphics.drawRect(100, 100, bouncerFrameWidth - 100, bouncerFrameHeight - 100);
        graphics.fillRect(100, 100, bouncerFrameWidth - 100, bouncerFrameHeight - 100);
        graphics.drawImage(offscreenImage, 0, 0, this);
        setVisible(true);
    }

//    void paintComponent(Graphics g) { // TODO
//        super.paint(g);
//        drawRectangles(g);
//    }

    public void paint(Graphics g) {
        drawRectangles(g);
        super.paint(g);
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
        return bouncerFrameWidth;
    }

    @Override
    public int getHeight() {
        return bouncerFrameHeight;
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
