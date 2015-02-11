package com.gsb.controles;

import com.gsb.modeles.Region;
import com.gsb.vues.Fen_Regions;
import com.gsb.vues.Fen_ficheRegion;

import java.util.Vector;

/**
 * Created by ipi on 10/02/2015.
 */
public class GestionRegions {
    public static int afficherListRegions() {
        Fen_Regions fen = new Fen_Regions();
        fen.setVisible(true);

        return 0;
    }

    public static Vector getRegionsList() {
        Vector<Region> regions = Region.lst();
        Vector result = new Vector();

        for (Region region: regions) {
            Vector row = new Vector();
            row.add(Integer.toString(region.getId()));
            row.add(region.getLibelle());
            result.addElement(row);
        }

        return result;
    }

    public static void afficherAjouterRegion() {
        Fen_ficheRegion fenFicheRegion = new Fen_ficheRegion();
        fenFicheRegion.setVisible(true);
    }

    public static void ajouterRegion(int numeroRegion, String nomRegion) {
        Region region = new Region(numeroRegion, nomRegion);
        region.creer();
    }
}
