package com.gsb.vues;

import com.gsb.controles.GestionPrincipale;
import com.gsb.controles.GestionRegions;
import com.gsb.modeles.Region;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;


public class Fen_Regions extends JFrame {
    private JLabel lblGestionRegions;
    private JTable tableRegions;

    private JButton ajouter;
    private JButton modifier;
    private JButton supprimer;
    private JButton consulter;
    private JButton quitter;

    public Fen_Regions() {
        super();
        Vector entetes = entetesTableau();
        Vector regions = GestionRegions.getRegionsList();

        tableRegions = new JTable(entetes, regions);

        JPanel panelRegions = new JPanel();
        panelRegions.setBackground(Color.LIGHT_GRAY);
        this.setResizable(true); // redimensionnable ou pas
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    public static Vector entetesTableau(){
        // Définition de l'entête des colonnes du Jtable
        Vector<String> entetes = new Vector<String>();
        entetes.add("Numéro");
        entetes.add("Libellé(s)");
        return entetes;
    }
}
