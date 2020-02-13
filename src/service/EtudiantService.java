package service;


import java.sql.SQLException;

import model.Etudiant;

public interface EtudiantService {
	public abstract void methode();
	// comparer deux etudiants ( age) 
		/*
		 * 
		 */
	public abstract String compareAge(Etudiant etu1, Etudiant etu2);

	// lire un etudiant 
	
	public abstract Etudiant lireEtudiant(int id) throws ClassNotFoundException, SQLException;

}
