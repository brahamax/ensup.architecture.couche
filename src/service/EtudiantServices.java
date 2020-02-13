package service;

import java.sql.SQLException;

import dao.EtudiantDAO;
import model.Etudiant;

public class EtudiantServices {
	private EtudiantDAO ed = new EtudiantDAO();

	 /**
	  * Afficher l'etudiant recupere par la methode getEtudiant
	  * @param int id
	  * @return String
	  */
	public String afficherEtudiant( int id) throws ClassNotFoundException, SQLException {

		return ed.getEtudiant(id).toString();
	}
	
	
	/**
	  * Afficher le resultat de l'insertion de l'etudiant
	  * @param Etudiant e
	  * @return Stringg
	  */
	public String insererEtudiant(Etudiant e) throws ClassNotFoundException, SQLException{
		
		if (ed.insertEtudiant(e)== 0) {
			return "Etudiant inseré";
		}
		return "Etudiant non inséré";
	}
	
	
	}
	


