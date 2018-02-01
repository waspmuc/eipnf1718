package com.lmu;

/**
 * @author Michael Kirsch
 * Diese Klasse repräsentiert das Spielfeld und enthält alle Elemente und die Steuerung der Padels.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Spielfeld extends JPanel implements KeyListener, Runnable { //Spielfeld ist ein JPanel und implementiert das Interface Keylistener

    private int rechteckRechtsPos_X = 580;
    private int rechteckRechtsPos_Y = 250;
    private int rechteckLinksPos_X = 0;
    private int rechteckLinksPos_Y = 250;
    private int ballXPosition = 400;
    private int ballYPosition = 200;

    private boolean ballbewegungGestartet = true;


    public void Spielfeld() { //Konstruktor; Bisher ohne weitere Funktion

    }


    public void paint(Graphics alterMaler) {
        super.paint(alterMaler); // Aufruf der Superlklasse, damit nicht alles überschrieben wird
        Graphics2D neuerMaler = (Graphics2D) alterMaler; //Konvertierung in ein "aktuelles" Graphics2D-Objekt. Swing ist alt! ;)

        neuerMaler.setColor(Color.RED); //Lieber Maler, nimm diese Farbe für all zukünftigen Malereien
        //neuerMaler.drawLine(30, 30, 400, 400);
        //neuerMaler.setColor(Color.GREEN);
        //neuerMaler.drawRect(30, 30, 400, 200);
        neuerMaler.fillRect(rechteckRechtsPos_X, rechteckRechtsPos_Y, 20, 100);
        neuerMaler.fillRect(rechteckLinksPos_X, rechteckLinksPos_Y, 20, 100);

        neuerMaler.setColor(Color.GREEN);
        neuerMaler.fillOval(ballXPosition, ballYPosition, 30, 30);

    }

    @Override
    public void keyTyped(KeyEvent ereignis) {
        System.out.println("KeyTyped wurde aufgerufen");

        if (ereignis.getKeyChar() == 't') {
            System.out.println("t wurde gedrückt");
        }


    }

    @Override
    public void keyPressed(KeyEvent ereignis) {
        System.out.println("KeyPressed wurde aufgerufen");

        System.out.println("Keycode is: " + ereignis.getKeyCode());

        if (ereignis.getKeyCode() == KeyEvent.VK_UP && rechteckRechtsPos_Y > 0) {
            System.out.println("Pfeiltaste nach oben wurde gedrückt");
            rechteckRechtsPos_Y = rechteckRechtsPos_Y - 50;
            //repaint(); //alternativ einmalig am Ende der Methode
        }

        if (ereignis.getKeyCode() == KeyEvent.VK_DOWN && rechteckRechtsPos_Y < (480)) {
            System.out.println("Y-Position: " + rechteckRechtsPos_Y);
            System.out.println("Pfeiltaste nach unten wurde gedrückt");
            rechteckRechtsPos_Y = rechteckRechtsPos_Y + 50;
            //repaint(); //alternativ einmalig am Ende der Methode
        }

        if (ereignis.getKeyChar() == 'w' && rechteckLinksPos_Y > 0) {
            System.out.println("w wurde gedrückt");
            rechteckLinksPos_Y = rechteckLinksPos_Y - 50;
            //repaint(); //alternativ einmalig am Ende der Methode
        }

        if (ereignis.getKeyChar() == 's' && rechteckLinksPos_Y < 480) {
            System.out.println("s wurde gedrückt");
            rechteckLinksPos_Y = rechteckLinksPos_Y + 50;
            //repaint(); //alternativ einmalig am Ende der Methode
        }

        if (ereignis.getKeyCode() == KeyEvent.VK_SPACE) { // Space-Taste wurde gedrückt
            System.out.println("Space wurde aufgerufen");
            ballbewegungGestartet = true;
            System.out.println(ballbewegungGestartet);
        }

        repaint();

    }

    @Override
    public void keyReleased(KeyEvent ereignis) {
        System.out.println("KeyReleased wurde aufgerufen");

    }

    @Override
    public void run() {

        boolean gameLoopIstAktiv = true;
        int offset_x = 1;
        int offset_y = 1;

        while (gameLoopIstAktiv) {

            try {
                if (ballbewegungGestartet) {

                    if (ballXPosition == 0) {  // linke Seite erreicht
                        offset_x = offset_x * -1;
                        ballXPosition = 250;
                        ballYPosition = 250;
                        ballbewegungGestartet = false;

                        Spielfenster referenzZumSpielefenster = (Spielfenster) SwingUtilities.getRoot(this); // Hole Referenz zum Spielefenster, um auf diese Komponenten zuzugreifen
                        referenzZumSpielefenster.spielstandAnzeige.setText("Spielstand 0 : 1"); // Ändere JLabel spielstandAnzeige

                        System.out.println("Linke Seite erreicht. Ball zurücksetzen.");
                    }

                    if (ballXPosition == 580) { //rechte Seite erreicht
                        offset_x = offset_x * -1;
                        ballXPosition = 250;
                        ballYPosition = 250;
                        ballbewegungGestartet = false;
                        System.out.println("Rechte Seite erreicht. Ball zurücksetzen.");
                    }

                    if (ballYPosition == 0) //oberes Seite erreicht
                        offset_y = offset_y * -1;

                    if (ballYPosition == 580) // untere Seite erreicht
                        offset_y = offset_y * -1;

                    ballXPosition = ballXPosition + offset_x;
                    ballYPosition = ballYPosition + offset_y;

                    repaint();
                }
                Thread.currentThread().sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
