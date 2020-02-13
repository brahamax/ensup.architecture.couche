package presentattion;

import java.util.Scanner;

public class lanceur {

	public static void main(String[] args) {
		// mot de passe mysql
		saisirMotDePasseMySQL();
		
		// 

	}

	/*
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
}
