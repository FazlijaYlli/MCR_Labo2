package org.example;


// pour le flickering -> dessiner dans une image qu'on affiche ensuite
// image fantôme ?

public class Main {
    public static void main(String[] args) {
        BouncersFrame frame = BouncersFrame.getInstance(800, 600);
//        Bouncers bouncers = new Bouncers(frame);
//        bouncers.start();
        frame.display();
    }
}