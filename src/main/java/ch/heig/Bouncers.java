package ch.heig;

import ch.heig.bouncers.Bouncable;
import ch.heig.displayers.FrameDisplayer;
import ch.heig.factories.BorderBouncersFactory;
import ch.heig.factories.BouncersFactory;
import ch.heig.factories.FilledBouncersFactory;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

/**
 * The main class of the program.
 *
 * @version 1.0 - 30.03.2023
 */
public class Bouncers {
    private final List<Bouncable> bouncers = new LinkedList<>();
    private static final int DELAY_MS = 10;
    private static final int NB_BOUNCERS = 10;
    private static boolean started = false;

    public static void main(String[] args) {
        new Bouncers().run();
    }

    /**
     * Starts the program.
     */
    public void run() {
        if (started) return;
        started = true;

        // Management of the keyboard
        FrameDisplayer.getInstance().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_F ->
                            createBouncers(FilledBouncersFactory.getInstance());
                    case KeyEvent.VK_B ->
                            createBouncers(BorderBouncersFactory.getInstance());
                    case KeyEvent.VK_E -> bouncers.clear();
                    case KeyEvent.VK_Q -> System.exit(0);
                }
            }
        });

        FrameDisplayer.getInstance().setTitle("Bouncers");

        // Actions to perform at each tick of the Timer.
        ActionListener al = e -> {
            for (Bouncable b : bouncers) {
                b.move();
                b.draw();
            }
            FrameDisplayer.getInstance().repaint();
        };

        // Create and start the timer
        new Timer(DELAY_MS, al).start();
    }

    /**
     * Creates a number of bouncers.
     *
     * @param fac The factory to use to create the bouncers.
     */
    private void createBouncers(BouncersFactory fac) {
        for (int i = 0; i < NB_BOUNCERS; ++i) {
            // We create a bouncer with the factory passed as parameter and we
            // add it to bouncers.
            bouncers.add(fac.makeSquare());
            bouncers.add(fac.makeCircle());
        }
    }
}