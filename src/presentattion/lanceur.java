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
	public static void main(String[] args) throws ParseException {
		 etudiantServices = new EtudiantServices();
		// mot de passe mysql
		saisirMotDePasseMySQL();

		// affichage menu
		affichageMenu();

		// choix de l'action é faire
		int choix = saisieOperation();
		
		// opération é faire

		operation(choix);
	}

	/**
	 * mot de passe base de donnée
	 */
	private static void saisirMotDePasseMySQL() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------------------------------------");
		System.out.print("Veuillez saisir le port de votre base de données Mysql : ");
		String port = sc.next();
		System.out.println();

		System.out.print("Veuillez saisir le login de votre base mysql : ");
		String login = sc.next();
		System.out.println();

		System.out.print("Veuillez saisir le mot de passe de votre base mysql : ");
		System.out.println();
		String password = sc.next();
		System.out.println("--------------------------------------------------------------");
		Bdd.passwd=password;
		Bdd.port=port;
		Bdd.login=login;
	}

	/**
	 * affichage
	 */

	private static void affichageMenu() {
		Scanner scan = new Scanner(System.in);

		// affichage basique
		System.out.println("--------------------------------------------------------------");

		System.out.println("Pour insérer un étudiant tapez 1");
		System.out.println("Pour lister les étudiants tapez 2");
		System.out.println("Pour supprimer un étudiant tapez 3");
		System.out.println("Pour modifier le nom d'un étudiant tapez 4");
		System.out.println("Pour consulter les informations d'un étudiant tapez 5");
		System.out.println("--------------------------------------------------------------");
		//
		System.out.print("Saisir un chiffre : ");
	}

	/**
<<<<<<< HEAD
	 * saisir une numéro qui correspond é une opération
	 * @return le numéro saisi
=======
	 * saisir une numéro qui correspond é une opération
	 * 
	 * @return le numéro saisi
>>>>>>> 6da6af048db17e3e1dc074922459f80b7d111f75
	 */

	private static Integer saisieOperation() {
		//
		Scanner scan = new Scanner(System.in);
		int saisie = scan.nextInt();
		return saisie;
	}

	/**
	 * 
<<<<<<< HEAD
	 * @param chiffre le choix de l'opération
	 * @throws ParseException 
=======
	 * @param chiffre le choix de l'opération
	 * @throws ParseException
>>>>>>> 6da6af048db17e3e1dc074922459f80b7d111f75
	 */
	private static void operation(int choix) throws ParseException {
		Scanner scan = new Scanner(System.in);
		switch (choix) {
		case 1:
			// enrégistrer un étudiant
			System.out.println();
			System.out.println("--------------------------------------------------------------");
			System.out.print("entrer le nom de l'étudiant : ");
			String nomEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer le prenom de l'étudiant : ");
			String prenomEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer l'email de l'étudiant : ");
			String emailEtudaint = scan.next();
			System.out.println();
			System.out.print("entrer l'adresse de l'école : ");
			String adresseEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer le téléphone de l'étudiant : ");
			String telephoneEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer la date de naissance de l'étudiant : ");
			String dateNaissance = scan.next();
			System.out.println();
			//
			Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dateNaissance);
			//
			Etudiant etudiant = new Etudiant(nomEtudiant, prenomEtudiant, emailEtudaint, adresseEtudiant,
					telephoneEtudiant, date);

			break;
		case 2:
			// lister les étudiants
	System.out.println("La liste des étudiants");
			// ServiceGestionEnsup.lireEtudiant();

			break;
		case 3:


			break;
		case 4:

			break;

		case 5:
			System.out.print("entrer le numéro de l'étudiant : ");
			int numero = scan.nextInt();
			//System.out.println();
			try {
				System.out.println(etudiantServices.lireEtudiant(numero));
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		default:

			break;

		}
	}

}
