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

    private int rechteckLinksPos_X = 0;
    private int rechteckLinksPos_Y = 250;
    private int rechteckRechtsPos_X = 580;
    private int rechteckRechtsPos_Y = 250;
    private int ballXPosition = 285;
    private int ballYPosition = 285;

    public void Spielfeld() { //Konstruktor; Bisher ohne weitere Funktion

    }


    public void paint(Graphics alterMaler) {
        super.paint(alterMaler); // Aufruf der Superlklasse, damit nicht alles überschrieben wird
        Graphics2D neuerMaler = (Graphics2D) alterMaler; //Konvertierung in ein "aktuelles" Graphics2D-Objekt. Swing ist alt! ;)

        neuerMaler.setColor(Color.RED); //Lieber Maler, nimm diese Farbe für all zukünftigen Malereien
        //neuerMaler.drawLine(30, 30, 400, 400);
        //neuerMaler.setColor(Color.GREEN);
        //neuerMaler.drawRect(30, 30, 400, 200);
        neuerMaler.fillRect(rechteckLinksPos_X, rechteckLinksPos_Y, 20, 100);
        neuerMaler.fillRect(rechteckRechtsPos_X, rechteckRechtsPos_Y, 20, 100);

        neuerMaler.setColor(Color.GREEN);
        neuerMaler.fillOval(ballXPosition, ballYPosition, 30, 30);

    }

    @Override
    public void keyTyped(KeyEvent ereignis) {
        System.out.println("KeyTyped wurde aufgerufen");
        //System.out.println(event.getKeyChar());

        if (ereignis.getKeyChar() == 't') {
            System.out.println("t wurde gedrückt");
        }


    }

    @Override
    public void keyPressed(KeyEvent ereignis) {
        System.out.println("KeyPressed wurde aufgerufen");

        System.out.println("Keycode is: " + ereignis.getKeyCode());

        if (ereignis.getKeyCode() == KeyEvent.VK_UP && rechteckLinksPos_Y > 0) {
            System.out.println("Pfeiltaste nach oben wurde gedrückt");
            rechteckLinksPos_Y = rechteckLinksPos_Y - 50;
            //repaint(); //alternativ einmalig am Ende der Methode
        }

        if (ereignis.getKeyCode() == KeyEvent.VK_DOWN && rechteckLinksPos_Y < (480)) {
            System.out.println("Y-Position: " + rechteckLinksPos_Y);
            System.out.println("Pfeiltaste nach unten wurde gedrückt");
            rechteckLinksPos_Y = rechteckLinksPos_Y + 50;
            //repaint(); //alternativ einmalig am Ende der Methode
        }

        if (ereignis.getKeyChar() == 'w' && rechteckRechtsPos_Y > 0) {
            System.out.println("w wurde gedrückt");
            rechteckRechtsPos_Y = rechteckRechtsPos_Y - 50;
            //repaint(); //alternativ einmalig am Ende der Methode
        }

        if (ereignis.getKeyChar() == 's' && rechteckRechtsPos_Y < 480) {
            System.out.println("s wurde gedrückt");
            rechteckRechtsPos_Y = rechteckRechtsPos_Y + 50;
            //repaint(); //alternativ einmalig am Ende der Methode
        }

        repaint();

    }

    @Override
    public void keyReleased(KeyEvent ereignis) {
        System.out.println("KeyReleased wurde aufgerufen");

    }

    @Override
    @SuppressWarnings()
    public void run() {

        int offset = 1;

        while (true) {
            try {

                System.out.println("Run wurde aufgerufen");


                if ((ballXPosition + 30) >= 600)
                    offset = offset * -1;

                ballXPosition = ballXPosition + offset;
                ballYPosition = ballYPosition + offset;


                repaint();

                Thread.currentThread().sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
