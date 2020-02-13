package service;

import java.sql.SQLException;

import dao.EtudiantDAO;
import model.Etudiant;

public class EtudiantServices {


	public String afficherEtudiant( int id) throws ClassNotFoundException, SQLException {

		return EtudiantDAO.getEtudiant(id).toString();
		
	public String insererEtudiant (Etudiant e){
		
		if (EtudiantDAO.insertEtudiant(e)== 0) {
			return "Etudiant inseré";
		}
		return "Etudiant non inséré";
	}
	
	
	}
	

}
