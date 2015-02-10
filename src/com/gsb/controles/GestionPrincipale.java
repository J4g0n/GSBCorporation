package com.gsb.controles;

import com.gsb.vues.Fen_Connexion;
import com.gsb.vues.Fen_Principale;

import javax.swing.*;


public class GestionPrincipale {
    private static JFrame fenetreCourante;

    public static void init() {
        fenetreCourante = new Fen_Connexion();
        fenetreCourante.setVisible(true);
    }

    public static void gerer() {
        fenetreCourante = new Fen_Principale();
        fenetreCourante.setVisible(true);
    }
}
