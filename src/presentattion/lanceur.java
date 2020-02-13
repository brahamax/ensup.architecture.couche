package presentattion;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import dao.Bdd;
import model.Etudiant;
import service.EtudiantServices;

public class lanceur {
	static EtudiantServices etudiantServices;

	/**
	 * Méthode main
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
	 * @return un numéro qui correspond à une opération
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
	 * @param choix le choix de l'opération à faire
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	private static void operation(int choix) throws ParseException, ClassNotFoundException, SQLException {
		Scanner scan = new Scanner(System.in);
		switch (choix) {
		case 1:
			// enrégistrer un étudiant
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
			System.out.print("entrer le téléphone de l'etudiant : ");
			String telephoneEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer la date de naissance de l'étudiant : format(yyyy-mm-dd) ");
			String dateNaissance = scan.next();
			System.out.println();
			//
			
			Etudiant etudiant = new Etudiant(nomEtudiant, prenomEtudiant, emailEtudaint, adresseEtudiant,
					telephoneEtudiant, dateNaissance);
			
			etudiantServices.insererEtudiant(etudiant);
			
			operationsRepetees();
			break;
		case 2:

			System.out.print("entrer le numéro de l'étudiant : ");
			int numero = scan.nextInt();
			try {
				System.out.println(etudiantServices.lireEtudiant(numero));

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			operationsRepetees();
			break;

		default:

			break;

		}
	}

	/**
	 * regroupement des opérations répétées
	 * @throws ParseException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private static void operationsRepetees() throws ParseException, ClassNotFoundException, SQLException {
		// affichage menu
		affichageMenu();

		// choix de l'action é faire
		int choix = saisieOperation();

		// opération é faire

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
