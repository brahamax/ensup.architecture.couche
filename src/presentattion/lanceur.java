package presentattion;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.Etudiant;

public class lanceur {

	public static void main(String[] args) throws ParseException {
		// mot de passe mysql
		saisirMotDePasseMySQL();

		// affichage menu
		affichageMenu();

		// choix de l'action à faire
		int choix = saisieOperation();
		
		// opération à faire
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
		System.out.println("--------------------------------------------------------------");
		//
		System.out.print("Saisir un chiffre : ");
	}

	/**
	 * saisir une numéro qui correspond à une opération
	 * @return le numéro saisi
	 */

	private static Integer saisieOperation() {
		//
		Scanner scan = new Scanner(System.in);
		int saisie = scan.nextInt();
		return saisie;
	}
	
	/**
	 * 
	 * @param chiffre le choix de l'opération
	 * @throws ParseException 
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
			System.out.println();
			System.out.println("La liste des étudiants");
			//ServiceGestionEnsup.lireEtudiant();

			break;
		case 3:
			// lister les étudiants
			

			break;
		default:
			
			break;
		
		}
	}

}
