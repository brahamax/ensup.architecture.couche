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

			public static Etudiant getEtudiant(int id) throws ClassNotFoundException, SQLException {
				Etudiant user = null;
				//connexion bdd
				B.connection();
				//traitement
				st = B.getCn().createStatement();
				sql = "Select * from etudiant Where id ="+Integer.toString(id);
				rs = st.executeQuery(sql);
				if(rs.next()){ 
					user = new Etudiant();
					
					user.setId(rs.getInt("id"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setEmail(rs.getString("email"));
					user.setAdresse(rs.getString("adresse"));
					user.setTelephone(rs.getString("telephone"));
					user.setDateNaiss(rs.getDate("date_naiss"));
					
				}
				else{
					System.out.println("Record Not Found...");
				}
				//deconnexion bdd
				B.deconnection();
				return user;
		
		
	}

			public static int insertEtudiant(Etudiant e) throws SQLException, ClassNotFoundException {
				if(e != null) {
					//connexion bdd
					B.connection();
					//traitement
					st = B.getCn().createStatement();
					sql = "insert into etudiant values('"+e.getId()+"','"+e.getNom()+"','"+e.getPrenom()+"','"+e.getEmail()+"','"+e.getAdresse()+"','"+e.getTelephone()+"',"+e.getDateNaiss()+")";
					st.executeUpdate(sql);
					//deconnexion bdd
					B.deconnection();
					return 0;
				}
				
				return 1;
				
			}
			


	
	
}
