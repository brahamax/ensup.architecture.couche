package service;

import model.Etudiant;

public class EtudiantServices implements EtudiantService {

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
	

}
