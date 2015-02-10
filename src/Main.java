import com.gsb.modeles.Region;
import com.gsb.modeles.Utilisateur;
import com.gsb.vues.Fen_Connexion;
import com.gsb.vues.util.ParametresIHM;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        ParametresIHM paramApp = new ParametresIHM();
        paramApp.setTitre("Nouveau titre");
        System.out.println("Titre: " + paramApp.getTitre() + "\n" + "Couleur du fond: " + paramApp.getCouleurFond());

        Utilisateur user = new Utilisateur("DURND", "1234", "", "", "", "", "", "");
        System.out.println("Utilisateur valide: " + user.verifier());

        Vector<Region> regions = Region.lst();
        for (Region reg: regions) {
            System.out.println(reg.getLibelle());
        }

        Fen_Connexion fen_connexion = new Fen_Connexion();
        fen_connexion.setVisible(true);
    }
}