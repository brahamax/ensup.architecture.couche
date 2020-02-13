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

		// choix de l'action � faire
		int choix = saisieOperation();
		
		// op�ration � faire

		operation(choix);
	}

	/**
	 * mot de passe base de donn�e
	 */
	private static void saisirMotDePasseMySQL() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------------------------------------");
		System.out.print("Veuillez saisir le port de votre base de donn�es Mysql : ");
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

		System.out.println("Pour ins�rer un �tudiant tapez 1");
		System.out.println("Pour lister les �tudiants tapez 2");
		System.out.println("Pour supprimer un �tudiant tapez 3");
		System.out.println("Pour modifier le nom d'un �tudiant tapez 4");
		System.out.println("Pour consulter les informations d'un �tudiant tapez 5");
		System.out.println("--------------------------------------------------------------");
		//
		System.out.print("Saisir un chiffre : ");
	}

	/**
	 * saisir une num�ro qui correspond � une op�ration
	 * @return le num�ro saisi
	 */

	private static Integer saisieOperation() {
		//
		Scanner scan = new Scanner(System.in);
		int saisie = scan.nextInt();
		return saisie;
	}

	/**
	 * @param choix le choix de l'op�ration
	 * @throws ParseException 
	 */
	private static void operation(int choix) throws ParseException {
		Scanner scan = new Scanner(System.in);
		switch (choix) {
		case 1:
			// enr�gistrer un �tudiant
			System.out.println();
			System.out.println("--------------------------------------------------------------");
			System.out.print("entrer le nom de l'�tudiant : ");
			String nomEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer le prenom de l'�tudiant : ");
			String prenomEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer l'email de l'�tudiant : ");
			String emailEtudaint = scan.next();
			System.out.println();
			System.out.print("entrer l'adresse de l'�cole : ");
			String adresseEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer le t�l�phone de l'�tudiant : ");
			String telephoneEtudiant = scan.next();
			System.out.println();
			System.out.print("entrer la date de naissance de l'�tudiant : ");
			String dateNaissance = scan.next();
			System.out.println();
			//
			Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dateNaissance);
			//
			Etudiant etudiant = new Etudiant(nomEtudiant, prenomEtudiant, emailEtudaint, adresseEtudiant,
					telephoneEtudiant, date);

			break;
		case 2:
			// lister les �tudiants
	System.out.println("La liste des �tudiants");
			// ServiceGestionEnsup.lireEtudiant();

			break;
		case 3:


			break;
		case 4:

			break;

		case 5:
			System.out.print("entrer le num�ro de l'�tudiant : ");
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
