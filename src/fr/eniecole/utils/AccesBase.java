package fr.eniecole.utils;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class AccesBase {
	

	public static Connection getConnection() throws Exception {
		InitialContext jndi=null;
		DataSource ds=null;
		Connection cnx = null;
		//----> Obtenir une référence sur le contexte initial JNDI
		try{
			jndi = new InitialContext();
			ds = (DataSource)jndi.lookup("java:comp/env/jdbc/Expeditor");
			cnx = ds.getConnection();
		}
		catch(NamingException e){
			e.printStackTrace();
		}
		
		return cnx;
	}
}
