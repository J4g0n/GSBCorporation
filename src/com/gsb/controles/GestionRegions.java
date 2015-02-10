package com.gsb.controles;

import com.gsb.modeles.Region;

import java.util.Vector;

/**
 * Created by ipi on 10/02/2015.
 */
public class GestionRegions {
    public static Vector getRegionsList() {
        Vector<Region> regions = Region.lst();
        Vector result = new Vector();

        for (Region region: regions) {
//System.out.println(r.getIdRegion()+" ===== "+r.getNomRegion());
            System.out.println(region.getId()+" "+region.getLibelle());
            Vector row = new Vector();
            row.add(Integer.toString(region.getId()));
            row.add(region.getLibelle());
            result.addElement(row);
        }

        return result;
    }
}
