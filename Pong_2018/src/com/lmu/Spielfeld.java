package com.lmu;

/**
 * @author Michael Kirsch
 * Diese Klasse repräsentiert das Spielfeld und enthält alle Elemente und die Steuerung der Padels.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Spielfeld extends JPanel implements KeyListener { //Spielfeld ist ein JPanel und implementiert das Interface Keylistener

    private int rechteckLinksPos_X = 0;
    private int rechteckLinksPos_Y = 250;
    private int rechteckRechtsPos_X = 580;
    private int rechteckRechtsPos_Y = 250;

    public void Spielfeld() { //Konstruktor; Bisher ohne weitere Funktion

    }


    public void paint(Graphics oldPainter) {
        super.paint(oldPainter); // Aufruf der Superlklasse, damit nicht alles überschrieben wird
        Graphics2D painter = (Graphics2D) oldPainter; //Konvertierung in ein "aktuelles" Graphics2D-Objekt. Swing ist alt! ;)

        painter.setColor(Color.RED);
        //painter.drawLine(30, 30, 400, 400);
        //painter.setColor(Color.GREEN);
        //painter.drawRect(30, 30, 400, 200);
        painter.fillRect(rechteckLinksPos_X, rechteckLinksPos_Y, 20, 100);
        painter.fillRect(rechteckRechtsPos_X, rechteckRechtsPos_Y, 20, 100);
    }

    @Override
    public void keyTyped(KeyEvent event) {
        System.out.println("KeyTyped wurde aufgerufen");
        //System.out.println(event.getKeyChar());

        if (event.getKeyChar() == 't') {
            System.out.println("t wurde gedrückt");
        }


    }

    @Override
    public void keyPressed(KeyEvent event) {
        System.out.println("KeyPressed wurde aufgerufen");

        System.out.println("Keycode is: " + event.getKeyCode());

        if (event.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Pfeiltaste nach oben wurde gedrückt");
            rechteckLinksPos_Y = rechteckLinksPos_Y - 30;
            //repaint(); //alternativ einmalig am Ende der Methode
        }

        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Pfeiltaste nach unten wurde gedrückt");
            rechteckLinksPos_Y = rechteckLinksPos_Y + 30;
            //repaint(); //alternativ einmalig am Ende der Methode
        }

        if (event.getKeyChar() == 'w') {
            System.out.println("w wurde gedrückt");
            rechteckRechtsPos_Y = rechteckRechtsPos_Y - 30;
            //repaint(); //alternativ einmalig am Ende der Methode
        }

        if (event.getKeyChar() == 's') {
            System.out.println("s wurde gedrückt");
            rechteckRechtsPos_Y = rechteckRechtsPos_Y + 30;
            //repaint(); //alternativ einmalig am Ende der Methode
        }

        repaint();

    }

    @Override
    public void keyReleased(KeyEvent event) {
        System.out.println("KeyReleased wurde aufgerufen");

    }
}
