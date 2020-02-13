package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Etudiant;


public class EtudiantDAO{
			private static Statement st = null;
			private static ResultSet rs=null;
			private static String sql = "";
			private static Bdd B= new Bdd(); 

			public static Etudiant get_nom_by_id(int a) throws ClassNotFoundException, SQLException {
				//connexion bdd
				B.connection();
				//traitement
				st = B.getCn().createStatement();
				sql = "Select * from etudiant Where id ="+Integer.toString(a);
				rs = st.executeQuery(sql);
				if(rs.next()){ 
				return Etudiant(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					
				}
				else{
					System.out.println("Record Not Found...");
				}
				//deconnexion bdd
				B.deconnection();
				return null;
		
		
	}



	
	
}
