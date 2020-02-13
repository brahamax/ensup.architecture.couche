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

		return 1;

	}

}
