package presentattion;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import dao.Bdd;
import model.Etudiant;
import service.EtudiantServices;

public class lanceur {
	static EtudiantServices etudiantServices;

	/**
	 * M�thode main
	 * 
	 * @param args
	 * @throws ParseException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
		etudiantServices = new EtudiantServices();

		Bdd.passwd = "root";
		Bdd.port = "3306";
		Bdd.login = "root";

		// affichage menu
		operationsRepetees();
	}

	/**
	 * affichage du menu
	 */
	private static void affichageMenu() {
		Scanner scan = new Scanner(System.in);

		// affichage basique
		System.out.println("--------------------------------------------------------------");
		System.out.println("Pour inserer un etudiant tapez 1");
		System.out.println("Pour consulter les informations d'un etudiant tapez 2");
		System.out.println("--------------------------------------------------------------");
		//
		System.out.print("Saisir un chiffre : ");
	}

	/**
	 * 
	 * @return un num�ro qui correspond a une op�ration
	 * saisir une numero qui correspond aune operation
	 * @return le numero saisi
	 */
	private static Integer saisieOperation() {
		//
		Scanner scan = new Scanner(System.in);
		int saisie = scan.nextInt();

		if (saisie != 1 && saisie != 2) {
			System.out.println("Mauvais choix d'operation veuillez recommencer");
			System.out.print("Saisir un chiffre : ");
			saisie = saisieOperation();
		}
		return saisie;
	}

	/**
	 * @param choix le choix de l'op�ration � faire
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @param chiffre le choix de l'operation
	 * @throws ParseException 
	 */
	private static void operation(int choix) throws ParseException, ClassNotFoundException, SQLException {
		Scanner scan = new Scanner(System.in);
		switch (choix) {
		case 1:
			// enr�gistrer un �tudiant
			System.out.println();
			System.out.println("--------------------------------------------------------------");
			System.out.print("entrer le nom de l'etudiant : ");
			String nomEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer le prenom de l'etudiant : ");
			String prenomEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer l'email de l'etudiant : ");
			String emailEtudaint = scan.next();
			System.out.println();
			System.out.print("entrer l'adresse de l'etudiant : ");
			String adresseEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer le t�l�phone de l'etudiant : ");
			String telephoneEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer la date de naissance de l'�tudiant : format(yyyy-mm-dd) ");
			String dateNaissance = scan.next();
			System.out.println();
			//
			
			Etudiant etudiant = new Etudiant(nomEtudiant, prenomEtudiant, emailEtudaint, adresseEtudiant,
					telephoneEtudiant, dateNaissance);
			
			etudiantServices.insererEtudiant(etudiant);
			
			operationsRepetees();
			break;
		case 2:

			System.out.print("entrer le num�ro de l'�tudiant : ");
			int numero = scan.nextInt();
			String reponse = etudiantServices.afficherEtudiant(numero);
			if(reponse == null) {
				System.out.println("Vous avez saisi un mauvais num�ro");
				operationsRepetees();
			} else {
				System.out.println(reponse);

			} 
			operationsRepetees();
			break;

		default:

			break;

		}
	}

	/**
	 * regroupement des op�rations r�p�t�es
	 * @throws ParseException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private static void operationsRepetees() throws ParseException, ClassNotFoundException, SQLException {
		// affichage menu
		affichageMenu();

		// choix de l'action � faire
		int choix = saisieOperation();

		// op�ration � faire

		operation(choix);
	}

	/**
	 * Si oui ou non on veut continuer l'operation
	 * @throws ParseException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private static void continuerOperation() throws ParseException, ClassNotFoundException, SQLException {
		System.out.println("");
		System.out.print("Voulez-vous continuer??? O/N : ");
		Scanner scan = new Scanner(System.in);

		String reponse = scan.next().toUpperCase();

		if (reponse.equals("O")) {
			operationsRepetees();
		} else {
			if (reponse.equals("F")) {
				System.out.println("Au revoir ........... ");
			} else {
				System.out.println(" Mauvais choix");
				continuerOperation();
			}
		}
	}

}
