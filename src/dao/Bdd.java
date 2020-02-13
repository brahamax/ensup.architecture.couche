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
 
 
 public void deconnection() throws SQLException {
	 this.cn.close();
		
 }
 
 public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPasswd() {
	return passwd;
}
public void setPasswd(String passwd) {
	this.passwd = passwd;
}
public Connection getCn() {
	return cn;
}

public void setCn(Connection cn) {
	this.cn = cn;
}

 
}
