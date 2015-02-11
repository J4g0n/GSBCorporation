package com.gsb.vues;


import com.gsb.controles.GestionRegions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.function.Function;

public class Fen_Principale extends JFrame {
    private JMenuBar menuBar;

    private JMenu menuFichier;
    private JMenu menuVisiteur;

    // menu
    private JMenu localisation;
    private JMenu gestionResponsables;
    private JMenu gestionDelegues;
    private JMenu gestionVisiteurs;

    // sous menus
    private JMenu gestionRegions;
    private JMenu gestionSecteurs;
    private JMenu gestionDepartement;

    private JMenuItem boutonQuitter;

    public Fen_Principale() {
        super();
        JPanel panneauPrincipal; // Panneau ou panel

        menuBar = new JMenuBar();

        menuFichier = new JMenu("Fichier");
        menuVisiteur = new JMenu("Visiteur");

        boutonQuitter = new JMenuItem("Quitter");
        boutonQuitter.addActionListener((e) -> System.exit(0));
        menuFichier.add(boutonQuitter);

        localisation = new JMenu("Localisation");
        gestionResponsables = new JMenu("Gestion Responsables [Régions]");
        ajouterGestionnaire(gestionResponsables, null);
        gestionDelegues = new JMenu("Gestion Délégués [Secteurs]");
        ajouterGestionnaire(gestionDelegues, null);
        gestionVisiteurs = new JMenu("Gestion Visiteurs [Départements]");
        ajouterGestionnaire(gestionVisiteurs, null);

        gestionRegions = new JMenu("Gestion Région");
        ajouterGestionnaire(gestionRegions, (e) -> GestionRegions.afficherListRegions());
        gestionSecteurs = new JMenu("Gestion Secteur");
        ajouterGestionnaire(gestionSecteurs, null);
        gestionDepartement = new JMenu("Gestion Département");
        ajouterGestionnaire(gestionDepartement, null);

        localisation.add(gestionRegions);
        localisation.add(gestionSecteurs);
        localisation.add(gestionDepartement);

        menuVisiteur.add(localisation);
        menuVisiteur.add(gestionResponsables);
        menuVisiteur.add(gestionDelegues);
        menuVisiteur.add(gestionVisiteurs);

        menuBar.add(menuFichier);
        menuBar.add(menuVisiteur);

        this.setJMenuBar(menuBar);

        panneauPrincipal = new JPanel();
        panneauPrincipal.setBackground(Color.LIGHT_GRAY);
        this.setResizable(true); // redimensionnable ou pas
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    private void ajouterGestionnaire(JMenuItem gestionnaire, Function callBack) {
        JMenuItem gerer = new JMenuItem("Gerer");
        gerer.addActionListener((e) -> {
            if (callBack != null) {
                callBack.apply(new Object());
            }
        });
        JMenuItem imprimer = new JMenuItem("Imprimer");
        gestionnaire.add(gerer);
        gestionnaire.add(imprimer);
    }
}
