package service;

import java.sql.SQLException;

import dao.EtudiantDAO;
import model.Etudiant;

public class EtudiantServices implements EtudiantService {
EtudiantDAO etudiantDao;


	/**
 * @param etudiantDao
 */
public EtudiantServices() {
	 etudiantDao = new EtudiantDAO();;
}

	@Override
	public void methode() {
		// TODO Auto-generated method stub
		
	}
	
	// methodes metiers 
	
	// comparer deux etudiants ( age) 
	/*
	 * 
	 */
	public  String compareAge(Etudiant etu1, Etudiant etu2) {
		String result ="";
		if(etu1.getDateNaiss().before(etu2.getDateNaiss())) 
			result = etu1.getPrenom() + " " + etu1.getNom() +" est plus agé  ";
		else
			result = etu2.getPrenom() + " " + etu2.getNom() +" est plus agé  ";
		
		 return result;
	}

	@Override
	public Etudiant lireEtudiant( int id) throws ClassNotFoundException, SQLException {

		return etudiantDao.getEtudiant(id);
	}
	

}
