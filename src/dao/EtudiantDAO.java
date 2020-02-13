package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EtudiantDAO{
			private static Statement st = null;
			private static ResultSet rs=null;
			private static String sql = "";
			private static Bdd B= new Bdd(); 

			public static void get_nom_by_id(int a) throws ClassNotFoundException, SQLException {
		//connexion bdd
				B.connection();
				//traitement
				st = B.getCn().createStatement();
				sql = "Select nom from etudiant Where id ="+Integer.toString(a);
				rs = st.executeQuery(sql);
				if(rs.next()){ 
					do{
					System.out.println(rs.getString(1));
					}while(rs.next());
				}
				else{
					System.out.println("Record Not Found...");
				}
				//deconnexion bdd
				B.deconnection();
		
		
	}



	
	
}
