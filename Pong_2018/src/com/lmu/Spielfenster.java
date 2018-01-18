package com.lmu;

/**
 * @author Michael Kirsch
 * Diese Klasse repräsentiert das Spielfenster in dem das JPanel enthalten ist, sowie die Punktestandanzeige.
 */

import javax.swing.*;
import java.awt.*;

public class Spielfenster extends JFrame { //Spielfenster leitet von JFrame ab und ist somit ein JFrame.

    Spielfeld spielfeld;
    JLabel score;

    public Spielfenster() { //In dem Konstruktor werden alle Konfigurationen vorgenommen. Er wird bei der Erstellung des Objekts EINMAL aufgerufen.

        spielfeld = new Spielfeld(); //Ein neues Objekt vom Typ Spielfeld wird erstellt
        score = new JLabel("Aktueller Spielstand 0 : 0 "); //Ein neues Objekt vom Typ JLabel wird erstellt und mit der Beschriftung initialisiert

        score.setFont(new Font("Calibri", Font.BOLD, 20)); //Setzt den Font der Score-Anzeige auf Calibri, Fett und Schriftgröße 20
        score.setForeground(new Color(0x0EE00)); //Setzt die Farbe auf Grün bzw. Hexadezimal 0EE00
        score.setForeground(Color.GREEN); //Alternativ auch so

        spielfeld.setFocusable(true); //Ermöglicht, dass die Keylistener auf die Tasteneingaben reagieren

        this.setSize(new Dimension(600, 600)); //Setzt die Größe des Spielfensters auf 600x600 Pixel
        this.setLocation(500, 100); //Setzt die Position des Spielfensters
        spielfeld.setBackground(new Color(0x212121)); //Setzt die die Hintergrundfarbe des Spielfelds auf Schwarz bzw. Hexadezimal 212121

        spielfeld.add(score); // Füge die Scoreanzeige dem Spielfeld hinzu
        spielfeld.addKeyListener(spielfeld); //Füge Keylistener dem Panel Spielfeld hinzu
        this.add(spielfeld); // Füge diesem Spielefenster (this) das Spielfeld, also das JPanel hinzu

        this.setVisible(true); //Mache das Fenster sichtbar
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Beende den Prozess/das Programm, wenn das Fenster geschlossen wird
    }
}
