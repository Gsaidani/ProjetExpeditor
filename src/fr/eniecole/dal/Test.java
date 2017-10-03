package fr.eniecole.dal;

import java.util.List;

import fr.eniecole.bean.Commande;

public class Test {

	public static void main(String[] args) {

		CommandeDAO dao = new CommandeDAO();
		try {
			List<Commande> liste = dao.getListeCommandes();
			System.out.println(liste);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
