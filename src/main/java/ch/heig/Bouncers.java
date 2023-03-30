package ch.heig;

import ch.heig.bouncers.Bouncable;
import ch.heig.displayers.FrameDisplayer;
import ch.heig.factories.BorderBouncersFactory;
import ch.heig.factories.BouncersFactory;
import ch.heig.factories.FilledBouncersFactory;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

public class Bouncers {
    private static final int DELAY_MS = 10;
    private static final int NB_BOUNCERS = 10;
    private static boolean started = false;
    private final List<Bouncable> bouncers = new LinkedList<>();


    public void run() {
        if (started) return;

        started = true;
        FrameDisplayer.getInstance().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_F -> createBouncers(FilledBouncersFactory.getInstance());
                    case KeyEvent.VK_B -> createBouncers(BorderBouncersFactory.getInstance());
                    case KeyEvent.VK_E -> bouncers.clear();
                    case KeyEvent.VK_Q -> System.exit(0);
                }
            }
        });

        FrameDisplayer.getInstance().setTitle("Bouncers");

        ActionListener al = e -> {
            for (Bouncable b : bouncers) {
                b.move();
                b.draw();
            }
            FrameDisplayer.getInstance().repaint();
        };

        new Timer(DELAY_MS, al).start();
    }

    public static void main(String[] args) {
        new Bouncers().run();
    }

    private void createBouncers(BouncersFactory fac) {
        for (int i = 0; i < NB_BOUNCERS; ++i) {
            // On crée un bouncer avec la factory passée en paramètre.
            bouncers.add(fac.makeSquare());
            bouncers.add(fac.makeCircle());
        }
    }
}