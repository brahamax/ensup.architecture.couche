package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Etudiant;

public class EtudiantDAO {
	private static Statement st = null;
	private static ResultSet rs = null;
	private static String sql = "";
	private static Bdd B = new Bdd();

	/**
	 * Renvoyer l'etudiant avec l'identifiant mentionne
	 * 
	 * @param int id
	 * @return Etudiant
	 */

	public Etudiant getEtudiant(int id) throws ClassNotFoundException, SQLException {
		Etudiant etudiant = null;

		// connexion bdd
		B.connection();
		// traitement
		st = B.getCn().createStatement();
		sql = "Select * from etudiant Where id =" + Integer.toString(id);
		rs = st.executeQuery(sql);
		if (rs.next()) {
			etudiant = new Etudiant();

			etudiant.setId(rs.getInt("id"));
			etudiant.setNom(rs.getString("nom"));
			etudiant.setPrenom(rs.getString("prenom"));
			etudiant.setEmail(rs.getString("email"));
			etudiant.setAdresse(rs.getString("adresse"));
			etudiant.setTelephone(rs.getString("telephone"));
			etudiant.setDateNaiss(rs.getString("date_naiss"));

		} else {
			System.out.println("Record Not Found...");
		}
		// deconnexion bdd
		B.deconnection();
		return etudiant;

<<<<<<< HEAD
	}

	/**
	 * Inserer un etudiant dans la base de donnee
	 * 
	 * @param Etudiant e
	 * @return int
	 */
	public int insertEtudiant(Etudiant e) throws SQLException, ClassNotFoundException {
		if (e != null) {
			// connexion bdd
			B.connection();
			// traitement
			st = B.getCn().createStatement();
			sql = "INSERT INTO `etudiant`(`nom`, `prenom`, `email`, `adresse`, `telephone`, `date_naiss`) values('"
					+ e.getNom() + "','" + e.getPrenom() + "','" + e.getEmail() + "','" + e.getAdresse() + "','"
					+ e.getTelephone() + "', null)";
			st.executeUpdate(sql);
			System.out.println("Etudiant enrégistré avec succès");
			// deconnexion bdd
			B.deconnection();
			return 0;
		}
=======
			
			 /**
			  *Renvoyer l'etudiant avec l'identifiant mentionne 
			  *@param id int 
			  *@return Etudiant
			  */
			
			public Etudiant getEtudiant(int id) throws ClassNotFoundException, SQLException {
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

			 /**
			  * Inserer un etudiant dans la base de donnee 
			  * @param e Etudiant
			  * @return int 
			  */
			public int insertEtudiant(Etudiant e) throws SQLException, ClassNotFoundException {
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
			
>>>>>>> bb002fcc0d1836a8f686dad612eb5c33b5d2e7a2

		return 1;

	}

}
