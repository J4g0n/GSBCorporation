package com.gsb.vues;


import com.gsb.controles.GestionRegions;
import com.gsb.vues.util.ParametresIHM;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.WindowEvent;

public class Fen_ficheRegion extends JFrame {
    private JLabel lblCodeRegion;
    private JLabel lblLibelleRegion;
    private JTextField txtCodeRegion;
    private JTextField txtlibelleRegion;
    private JButton btnSauver;
    private JButton btnAnnuler;
    private String type;

    public Fen_ficheRegion(String type) {
        super();
        this.type = type;
        ParametresIHM parametresIHM = new ParametresIHM();
        JPanel regionPanel = new JPanel();
        lblCodeRegion = new JLabel("Numéro: ");
        lblLibelleRegion = new JLabel("Libellé: ");
        txtCodeRegion = new JTextField(null, null, 5);
        txtlibelleRegion = new JTextField(null, null, 10);
        btnSauver = new JButton("Valider");
        btnAnnuler = new JButton("Annuler");

        setEventsHandler();

        regionPanel.add(lblCodeRegion);
        regionPanel.add(txtCodeRegion);
        regionPanel.add(lblLibelleRegion);
        regionPanel.add(txtlibelleRegion);
        if (!type.equals("consulter")) {
            regionPanel.add(btnSauver);
            regionPanel.add(btnAnnuler);
        }

        this.setContentPane(regionPanel);

        this.setTitle(parametresIHM.getTitre());
        this.setBackground(parametresIHM.getCouleurFond());
        this.setSize(200, 200); // largeur, hauteur
        this.setResizable(true); // redimensionnable ou pas
        this.setLocationRelativeTo(null); // positionnement par rapport à une autre fenetre
    }

    private void setEventsHandler() {
        btnSauver.addActionListener((e) -> handleValider());
        btnAnnuler.addActionListener((e) -> this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)));
    }

    private void handleValider() {
        traitement();
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void traitement() {
        int code = Integer.parseInt(txtCodeRegion.getText());
        String libelle = txtlibelleRegion.getText();

        switch (type) {
            case "ajouter":
                GestionRegions.ajouterRegion(code, libelle);
                break;
            case "modifier":
                GestionRegions.modifierRegion(code, libelle);
                break;
            case "supprimer":
                GestionRegions.supprimerRegion(code, libelle);
                break;
        }
    }
}
