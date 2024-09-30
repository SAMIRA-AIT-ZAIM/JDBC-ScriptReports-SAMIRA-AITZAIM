package ex2.d;

import ex1.connexion.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExoJDBC {

    public static void main(String[] args) {
        String developpeurNom = "WAFI"; // Remplace par le nom du programmeur 

        try {
            // Requête SQL pour obtenir le nombre total de scripts réalisés par un développeur donné
            String req = "SELECT SUM(NBScripts) AS totalScripts " +
                         "FROM devdata " +
                         "WHERE Developpeurs = '" + developpeurNom + "'"; 

            Statement st = Connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            
            // Vérifier si des résultats sont retournés
            if (rs.next()) {
                int totalScripts = rs.getInt("totalScripts");
                if (totalScripts > 0) {
                    System.out.println("Total Scripts réalisés par " + developpeurNom + ": " + totalScripts);
                } else {
                    System.out.println("Aucun script réalisé par " + developpeurNom + ".");
                }
            } else {
                System.out.println("Développeur non trouvé.");
            }

            // Fermer les ressources
            rs.close();
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ExoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
