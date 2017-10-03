package fr.eniecole.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import fr.eniecole.bean.Commande;
import fr.eniecole.bean.Employe;
import fr.eniecole.utils.AccesBase;
import fr.eniecole.utils.ManipDate;
import fr.eniecole.utils.ManipEnumStatut;

public class CommandeDAO {

	Logger logger = Logger.getLogger(this.getClass().getName());
	
	private final static String GET_LISTE = "SELECT "
			+ "c.id, c.societe,	c.statut, c.date, c.employe, e.id as idEmploye,	e.nom, e.prenom, e.role, e.mail,e.password "
			+ "FROM Commandes c "
			+ "LEFT JOIN Employes e ON e.id = c.employe "
			+ "WHERE c.statut IN ('A TRAITER', 'EN COURS DE TRAITEMENT')"
			+ "ORDER BY c.id;";
	
	private final static String COL_ID = "id";
	private final static String COL_SOCIETE = "societe";
	private final static String COL_POIDS = "poids";
	private final static String COL_STATUT = "statut";
	private final static String COL_DATE = "date";
	private final static String COL_EMPLOYE = "employe";
	private final static String COL_NOM = "nom";
	private final static String COL_PRENOM = "prenom";
	private final static String COL_ROLE = "role";
	private final static String COL_MAIL = "mail";
	private final static String COL_MDP = "password";
	
	
	public List<Commande> getListeCommandes() throws Exception{
		List<Commande> listeCommandes = new ArrayList<>();
		try (Connection cnx = AccesBase.getConnection()){
			PreparedStatement cmd = cnx.prepareStatement(GET_LISTE);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()){
				listeCommandes.add(itemBuilder(rs));
			}
		} catch (SQLException e) {
			logger.severe(e.getMessage());
		}
		return listeCommandes;
	}
	
	public Map<Employe, Integer> getNbCommandesParEmploye(){
		Map<Employe, Integer> nbCommandes = new HashMap<>();
		try(Connection cnx = AccesBase.getConnection()){
			//PreparedStatement cmd = cnx.prepareStatement(sql);
		} catch (SQLException e) {
			logger.severe(e.getMessage());
		}
		
		return nbCommandes;
	}

	private Commande itemBuilder(ResultSet rs) throws Exception {
		Commande commande = new Commande();
		try {
			commande.setId(rs.getInt(COL_ID));
			// TODO : récuperer tous les éléments de la société
			int idSociete = rs.getInt(COL_SOCIETE);
			commande.setPoidsTotal(rs.getFloat(COL_POIDS));
			commande.setStatut(ManipEnumStatut.StringToEnum(rs.getString(COL_STATUT)));
			commande.setDateCommande(ManipDate.dateSQLVersUtil(rs.getDate(COL_DATE)));
			Employe employe = new Employe();
			// TODO : faire une classe qui permet de récupérer l'enum role
			employe.setId(rs.getInt(COL_EMPLOYE));
			employe.setNom(rs.getString(COL_NOM));
			employe.setPrenom(rs.getString(COL_PRENOM));
			employe.setEmail(rs.getString(COL_MAIL));
			employe.setPassword(rs.getString(COL_MDP));
			commande.setEmploye(employe);
		} catch (SQLException e) {
			logger.severe(e.getMessage());
		}
		return commande;
	}
}
