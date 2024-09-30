/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1.rapport;

import ex1.connexion.Connexion;
import ex1.dao.IDao;
import ex1.entitie.DevData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salam
 */
public class DevDataRapp implements IDao <DevData>{

    @Override
public boolean create(DevData d) {
    boolean r = false;
    try {
        String req = "INSERT INTO `devdata` (`Developpeurs`, `Jour`, `NbScripts`) VALUES ('" + d.getDeveloppeurs() + "', '" + d.getJour() + "', " + d.getNbscript() + ");";
        Statement st = Connexion.getCn().createStatement();
        int n = st.executeUpdate(req);
        if (n == 1) {
            r = true;
        }
    } catch (SQLException ex) {
        Logger.getLogger(DevDataRapp.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
}



    @Override
    public boolean update(DevData d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
public boolean delete(DevData d) {
    boolean r = false;
    try {
        // En entourant la valeur de d.getDeveloppeurs() par des guillemets simples
        String req = "DELETE FROM `devdata` WHERE Developpeurs = '" + d.getDeveloppeurs() + "'";
        Statement st = Connexion.getCn().createStatement();
        int n = st.executeUpdate(req);
        if (n == 1) {
            r = true;
        }
    } catch (SQLException ex) {
        Logger.getLogger(DevDataRapp.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
}


   
}
