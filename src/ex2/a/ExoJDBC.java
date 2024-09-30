package ex2.a;

import ex1.connexion.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExoJDBC {

    public static void main(String[] args) {
        try {
            // Nouvelle requête SQL pour obtenir le développeur ayant réalisé le maximum de scripts par jour
            String req = "SELECT Developpeurs, jour, MAX(NBScripts) as max_scripts " +
                         "FROM devdata " +
                         "GROUP BY jour;";

            Statement st = Connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            
            // Parcourir les résultats
            while (rs.next()) {
                String developpeur = rs.getString("Developpeurs");
                String jour = rs.getString("jour");
                int maxScripts = rs.getInt("max_scripts");
                System.out.println("Développeur: " + developpeur + ", Jour: " + jour + ", MaxScripts: " + maxScripts);
            }

            // Fermer les ressources
            rs.close();
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ExoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
