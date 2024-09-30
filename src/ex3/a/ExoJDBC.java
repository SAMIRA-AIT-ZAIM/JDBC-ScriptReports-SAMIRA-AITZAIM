package ex3.a;

import ex1.connexion.Connexion;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExoJDBC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre requête SQL :");
        String requete = scanner.nextLine(); // Lire la requête SQL

        try {
            Statement st = Connexion.getCn().createStatement();
            boolean isResultSet = st.execute(requete); 

            if (isResultSet) {
                // Si la requête retourne un ResultSet
                ResultSet rs = st.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();

                // Afficher le nombre de colonnes
                int columnCount = rsmd.getColumnCount();
                System.out.println("Nombre de colonnes : " + columnCount);

                // Afficher le nom et le type de chaque colonne
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    String columnType = rsmd.getColumnTypeName(i);
                    System.out.println("Colonne " + i + ": " + columnName + " (Type: " + columnType + ")");
                }

                // Afficher le contenu de la table ligne par ligne
                while (rs.next()) {
                    StringBuilder row = new StringBuilder();
                    for (int i = 1; i <= columnCount; i++) {
                        row.append(rs.getString(i)).append("\t");
                    }
                    System.out.println(row.toString());
                }

                // Fermer le ResultSet
                rs.close();
            } else {
                // Si la requête ne retourne pas de ResultSet 
                int rowsAffected = st.getUpdateCount();
                System.out.println("Nombre de lignes modifiées : " + rowsAffected);
            }

            // Fermer la déclaration
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(ExoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            scanner.close();
        }
    }
}
