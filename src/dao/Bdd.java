package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bdd {
	
private String url = "jdbc:mysql://localhost" ;
public static String login ="root";
public static String passwd="";
public static String port = "";
private String bd="archi_couche";
private Connection cn =null;

/**
 * Se connecter au serveur de base de donnee.
 */

 public void connection() throws ClassNotFoundException {
		 url = url + ":"+ port + "/" + bd;
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 this.cn= DriverManager.getConnection(url,login,passwd);
			}
			 catch (SQLException e) {
		e.printStackTrace();	 
			 
		 }
		 
		 
		
	}
 
 /**
  * Se deconnecter du serveur de base de donnee.
  */
 public void deconnection() throws SQLException {
	 this.cn.close();
		
 }
 
 /**
  * Retourne l'url du serveur de la BDD.
  * @return String
  */
 public String getUrl() {
	return url;
}
 /**
  * Modifier l'url du serveur de la BDD.
  * @param String url
  */
 
public void setUrl(String url) {
	this.url = url;
}

/**
 * Retourne le login du serveur de la BDD.
 * @return String
 */
public String getLogin() {
	return login;
}
/**
 * Modifier l'url du serveur de la BDD.
 */
public void setLogin(String login) {
	this.login = login;
}
/**
 * Retourne le mot de passe du serveur de la BDD.
 * @return String
 */
public String getPasswd() {
	return passwd;
}

/**
 * Modifier le mot de passe du serveur de la BDD.
 * @param String passwd
 */
public void setPasswd(String passwd) {
	this.passwd = passwd;
}

/**
 * Retourne la connection
 * @return Connection
 */
public Connection getCn() {
	return cn;
}

/**
 * Modifier l'attribut Connection cn.
 * @param Connection cn
 */
public void setCn(Connection cn) {
	this.cn = cn;
}

 
}
