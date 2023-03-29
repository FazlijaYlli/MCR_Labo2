package ch.heig;


// pour le flickering -> dessiner dans une image qu'on affiche ensuite
// image fantôme ?

import ch.heig.renderers.BouncersFrame;

public class Main {
    public static void main(String[] args) {
        BouncersFrame frame = BouncersFrame.getInstance(800, 800);
//        Bouncers bouncers = new Bouncers(frame);
//        bouncers.start();
        frame.display();
    }
}