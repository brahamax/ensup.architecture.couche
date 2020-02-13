package service;


import model.Etudiant;

public interface EtudiantService {
	public abstract void methode();
	// comparer deux etudiants ( age) 
		/*
		 * 
		 */
	public abstract String compareAge(Etudiant etu1, Etudiant etu2);
	
	public void insererEtudiant(Etudiant etudiant);
}
