package ex2.c;

import ex1.connexion.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExoJDBC {

    public static void main(String[] args) {
        try {
            // Requête SQL pour obtenir le nombre total de scripts réalisés en une semaine
            String req = "SELECT SUM(NBScripts) AS totalScripts " +
                         "FROM devdata " +
                         "WHERE jour >= 'lundi' AND jour <= 'vendredi'"; // Remplace ces dates par la période souhaitée

            Statement st = Connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            
            // Vérifier si des résultats sont retournés
            if (rs.next()) {
                int totalScripts = rs.getInt("totalScripts");
                System.out.println("Total Scripts réalisés en une semaine: " + totalScripts);
            }

            // Fermer les ressources
            rs.close();
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ExoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
