package service;

import model.Etudiant;

public class EtudiantService {
	// créer un instance de DAO pour éxécuter les réquetes clients 
	

	/**
	 * 
	 */
	public EtudiantService() {
		
	}
	
	// methodes metiers 
	
	// comparer deux etudiants ( age) 
	/*
	 * 
	 */
	private  String compareAge(Etudiant etu1, Etudiant etu2) {
		String result ="";
		if(etu1.getDateNaiss().before(etu2.getDateNaiss())) 
			result = etu1.getPrenom() + " " + etu1.getNom() +" est plus agé  ";
		else
			result = etu2.getPrenom() + " " + etu2.getNom() +" est plus agé  ";
		
		 return result;
	}
	
	

}
