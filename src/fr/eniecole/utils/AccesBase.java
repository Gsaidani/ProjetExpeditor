package fr.eniecole.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;


public class AccesBase {
	
	/*public static Connection getConnection() throws SQLException{
		
		String uri = Parametre.lire("dbUrl");
		String user = Parametre.lire("dbUser");
		String password = Parametre.lire("dbPassword");
		
		DriverManager.registerDriver(new SQLServerDriver());
		Connection connexion =  DriverManager.getConnection(uri, user, password);
		
		return connexion;		
	}*/
	public static Connection getConnection() throws SQLException {
		InitialContext jndi=null;
		DataSource ds=null;
		//----> Obtenir une référence sur le contexte initial JNDI
		try{
		jndi=new InitialContext();}
		catch(NamingException e){
		//throw new Exception("Erreur d'accès au contexte initial JNDI");
			}
		//----> recherche de la source de données
		try{
		ds=(DataSource)jndi.lookup("java:comp/env/jdbc/Expeditor");}
		catch(NamingException e){
		//throw new Exception("Objet introuvable dans l'arbre JNDI:"+e.getMessage());
		}
		//----> obtenir une connexion
		/*try{
		return ds.getConnection();}
		catch(SQLException e){
		//throw new Exception("Impossible d'obtenir une connexion:"+e.getMessage());			
			}*/
		return ds.getConnection();
		}
}
