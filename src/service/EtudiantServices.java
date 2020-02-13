package service;

import java.sql.SQLException;

import dao.EtudiantDAO;
import model.Etudiant;

public class EtudiantServices {
	private EtudiantDAO ed = new EtudiantDAO();

<<<<<<< HEAD
	/**
	 * Afficher l'etudiant recupere par la methode getEtudiant
	 * 
	 * @param int id
	 * @return String
	 */
=======
	 /**
	  *Afficher l'etudiant recupere par la methode getEtudiant
	  *@param id int
	  *@return String
	  */
>>>>>>> bb002fcc0d1836a8f686dad612eb5c33b5d2e7a2
	public String afficherEtudiant(int id) throws ClassNotFoundException, SQLException {

		return ed.getEtudiant(id).toString();
	}

	/**
<<<<<<< HEAD
	 * Afficher le resultat de l'insertion de l'etudiant
	 * 
	 * @param Etudiant e
	 * @return String
	 */
	public String insererEtudiant(Etudiant e) throws ClassNotFoundException, SQLException {

		if (ed.insertEtudiant(e) == 0) {
			return "Etudiant insere";

=======
	  *Afficher le resultat de l'insertion de l'etudiant
	  *@param e Etudiant
	  *@return String
	  */
	public String insererEtudiant(Etudiant e) throws ClassNotFoundException, SQLException{
		
		if (ed.insertEtudiant(e)== 0) {
			return "Etudiant inserÃ©";
>>>>>>> bb002fcc0d1836a8f686dad612eb5c33b5d2e7a2
		}
		return "Etudiant non inseré";
	}

}
