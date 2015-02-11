package com.gsb.vues;

import com.gsb.controles.GestionPrincipale;
import com.gsb.controles.GestionRegions;
import com.gsb.modeles.Region;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Vector;


public class Fen_Regions extends JFrame {
    private JLabel lblGestionRegions;
    private JTable tableRegions;

    public Fen_Regions() {
        super();
        JScrollPane jScrollPane;
        JPanel jPanel = new JPanel();
        Vector entetes = entetesTableau();
        Vector regions = GestionRegions.getRegionsList();

        tableRegions = new JTable(regions, entetes);
        jScrollPane = new JScrollPane(tableRegions);

        jPanel = addButtons(jPanel);
        lblGestionRegions = new JLabel("GESTION REGIONS");

        this.add(lblGestionRegions, BorderLayout.NORTH);
        this.add(jScrollPane, BorderLayout.CENTER);
        this.add(jPanel, BorderLayout.SOUTH);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(true); // redimensionnable ou pas
    }

    public static Vector entetesTableau(){
        // Définition de l'entête des colonnes du Jtable
        Vector<String> entetes = new Vector<String>();
        entetes.add("Numéro");
        entetes.add("Libellé(s)");
        return entetes;
    }

    public JPanel addButtons(JPanel panelBoutons) {
        JButton ajouter = new JButton("Ajouter");
        ajouter.addActionListener((e) -> GestionRegions.afficherAjouterRegion());
        JButton modifier = new JButton("Modifier");
        JButton supprimer = new JButton("Supprimer");
        JButton consulter  = new JButton("Consulter");
        JButton quitter = new JButton("Quitter");
        quitter.addActionListener((e) -> this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)));

        panelBoutons.setLayout(new GridLayout(1, 5));

        panelBoutons.add(ajouter);
        panelBoutons.add(modifier);
        panelBoutons.add(supprimer);
        panelBoutons.add(consulter);
        panelBoutons.add(quitter);

        return panelBoutons;
    }

    public void handleAjout() {

    }
}
