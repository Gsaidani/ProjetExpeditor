package fr.eniecole.utils;

import java.util.ResourceBundle;


public class Parametre {

	
	public static String lire(String cle){
		ResourceBundle bundle = ResourceBundle.getBundle("fr.eniecole.utils.param");
		
		return (null!=bundle) ? bundle.getString(cle) : null;
	}

}
