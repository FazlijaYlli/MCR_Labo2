package ch.heig;

import ch.heig.bouncers.Bouncable;
import ch.heig.displayers.FrameDisplayer;
import ch.heig.factories.BorderBouncersFactory;
import ch.heig.factories.BouncersFactory;
import ch.heig.factories.FilledBouncersFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

public class Bouncers {
    private static final int DELAY_MS = 10;
    private static final int NB_BOUNCERS = 10;

    private final List<Bouncable> bouncers = new LinkedList<>();

    private boolean started = false;

    public void run(int delay) {
        if (started) return;
        started = true;
        FrameDisplayer.getInstance().setTitle("Bouncers");
        FrameDisplayer.getInstance().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_E -> bouncers.clear();
                    case KeyEvent.VK_F -> createBouncers(NB_BOUNCERS, FilledBouncersFactory.getInstance());
                    case KeyEvent.VK_B -> createBouncers(NB_BOUNCERS, BorderBouncersFactory.getInstance());
                    case KeyEvent.VK_Q -> System.exit(0);
                }
            }
        });

        ActionListener al = e -> {
            for (Bouncable b : bouncers) {
                b.move();
                b.draw();
            }
            FrameDisplayer.getInstance().repaint();
        };

        new Timer(delay, al).start();
    }

    public static void main(String[] args) {
        new Bouncers().run(DELAY_MS);
    }

    private void createBouncers(int nb, BouncersFactory fac) {
        for (int i = 0 ; i < nb ; ++i) {
            // On crée un bouncer avec la factory passée en paramètre.
            bouncers.add(fac.createSquare());
        }
    }
}