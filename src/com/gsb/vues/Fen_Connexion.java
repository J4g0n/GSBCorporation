package com.gsb.vues;

import com.gsb.modeles.Utilisateur;
import com.gsb.vues.util.ParametresIHM;

import javax.swing.*;


public class Fen_Connexion extends JFrame {
    private JLabel lblLogin;
    private JLabel lblPassword;
    private JTextField txtLogin;
    private JPasswordField txtPassword;
    private JButton btnValider;
    private JButton btnAnnuler;
    private JPanel loginPanel;

    public Fen_Connexion() {
        super();
        ParametresIHM parametresIHM = new ParametresIHM();
        loginPanel = new JPanel();
        lblLogin = new JLabel("Login");
        lblPassword = new JLabel("Password");
        txtLogin = new JTextField(null, null, 10);
        txtPassword = new JPasswordField(null, null, 10);
        btnValider = new JButton("Valider");
        btnAnnuler = new JButton("Annuler");

        setEventsHandler();

        loginPanel.add(lblLogin);
        loginPanel.add(txtLogin);
        loginPanel.add(lblPassword);
        loginPanel.add(txtPassword);
        loginPanel.add(btnValider);
        loginPanel.add(btnAnnuler);

        this.setContentPane(loginPanel);

        this.setTitle(parametresIHM.getTitre());
        this.setSize(400, 200); // largeur, hauteur
        this.setResizable(true); // redimensionnable ou pas
        this.setLocationRelativeTo(null); // positionnement par rapport à une autre fenetre
    }

    private void setEventsHandler() {
        btnValider.addActionListener((e) -> {
            handleLogin();
        });
    }

    private void handleLogin() {
        String login = txtLogin.getText();
        String password = new String(txtPassword.getPassword());
        Utilisateur utilisateur = new Utilisateur(login, password, "", "", "", "", "", "");

        if (utilisateur.verifier()) {
            JOptionPane.showMessageDialog(null, "Login effectué, cliquer sur ok pour continuer...", "Login réussi",  JOptionPane.CLOSED_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "Mauvais login ou mot de passe", "Echec login",  JOptionPane.OK_OPTION);
        }
    }
}
