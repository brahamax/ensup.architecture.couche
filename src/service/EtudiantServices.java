package service;

import java.sql.SQLException;

import dao.EtudiantDAO;
import model.Etudiant;

public class EtudiantServices {

	public String afficherEtudiant(int id) throws ClassNotFoundException, SQLException {

		return EtudiantDAO.getEtudiant(id).toString();
	}

	public String insererEtudiant(Etudiant e) throws ClassNotFoundException, SQLException {

		if (EtudiantDAO.insertEtudiant(e) == 0) {
			return "Etudiant inser�";
		}
		return "Etudiant non inser�";
	}

	// comparer deux etudiants ( age)
	/*
	 * 
	 */
	public String compareAge(Etudiant etu1, Etudiant etu2) {
		String result = "";
		if (etu1.getDateNaiss().before(etu2.getDateNaiss()))
			result = etu1.getPrenom() + " " + etu1.getNom() + " est plus ag�  ";
		else
			result = etu2.getPrenom() + " " + etu2.getNom() + " est plus ag�  ";

		return result;
	}

	public Etudiant lireEtudiant(int id) throws ClassNotFoundException, SQLException {

		return EtudiantDAO.getEtudiant(id);

	}
}
