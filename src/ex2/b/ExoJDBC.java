package ex2.b;

import ex1.connexion.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExoJDBC {

    public static void main(String[] args) {
        try {
            // Requête SQL pour obtenir la liste des développeurs triée par le nombre total de scripts
            String req = "SELECT Developpeurs, SUM(NBScripts) AS c " +
                         "FROM devdata " +
                         "GROUP BY Developpeurs " +
                         "ORDER BY c DESC;";

            Statement st = Connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            
            // Parcourir les résultats
            while (rs.next()) {
                String developpeur = rs.getString("Developpeurs");
                int totalScripts = rs.getInt("c");
                System.out.println("Développeur: " + developpeur + ", Total Scripts: " + totalScripts);
            }

            // Fermer les ressources
            rs.close();
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ExoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
