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

import fr.eniecole.bean.Employe;
import fr.eniecole.bean.Societe;
import fr.eniecole.bean.Article;
import fr.eniecole.bean.Commande;
import fr.eniecole.utils.AccesBase;
import fr.eniecole.utils.ManipDate;
import fr.eniecole.utils.ManipEnumStatut;

public class CommandeDAO {

	Logger logger = Logger.getLogger(this.getClass().getName());

	private final static String GET_LISTE = "SELECT * " + "FROM Commandes c "
			+ "LEFT JOIN Employes e ON e.idEmploye = c.idEmploye "
			+ "WHERE c.statut IN ('A TRAITER', 'EN COURS DE TRAITEMENT')" + "ORDER BY c.idCommande;";

	private final static String GET_COMMANDE_PRIORITAIRE = "SELECT TOP 1 *" + "FROM Commandes c"
			+ "WHERE c.statut = 'A TRAITER" + "ORDER BY c.date;";

	private final static String GET_DETAIL_COMMANDE = "SELECT *" + "FROM Commandes c"
			+ "LEFT JOIN Societes s ON c.idSociete = s.idSociete"
			+ "LEFT JOIN LignesCommandes lc ON c.idCommande = lc.idCommande"
			+ "INNER JOIN Articles a ON  lc.idArticle= a.id" + "WHERE c.idCommande=? ";

	private final static String COL_IDCOMMANDE = "idCommande";
	private final static String COL_IDSOCIETE = "idSociete";
	private final static String COL_POIDSTOTAL = "poidsTotal";
	private final static String COL_STATUT = "statut";
	private final static String COL_DATE = "date";
	private final static String COL_IDEMPLOYE = "idEmploye";
	private final static String COL_NOM = "nom";
	private final static String COL_PRENOM = "prenom";
	private final static String COL_ROLE = "role";
	private final static String COL_MAIL = "mail";
	private final static String COL_MDP = "password";
	private final static String COL_ADRESSE = "adresse";
	private final static String COL_NOM_SOCIETE = "nomSociete";
	private final static String COL_IDARTICLE = "idArticle";
	private final static String COL_LIBELLE = "libelle";
	private final static String COL_POIDSARTICLE = "poidsArticle";
	private final static String COL_QUANTITE = "quantite";

	public Commande getCommande() throws Exception {
		Commande c = new Commande();
		try (Connection cnx = AccesBase.getConnection()) {
			PreparedStatement cmd = cnx.prepareStatement(GET_COMMANDE_PRIORITAIRE);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				c = itemBuilder(rs);
			}
		} catch (SQLException e) {
			logger.severe(e.getMessage());
		}
		return c;
	}

	public Commande getDetailCommande(Commande commandeDetail) throws Exception {

		try (Connection cnx = AccesBase.getConnection()) {
			PreparedStatement cmd = cnx.prepareStatement(GET_DETAIL_COMMANDE);
			cmd.setInt(1, commandeDetail.getId());
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				commandeDetail = itemBuilder(rs);
			}
		} catch (SQLException e) {
			logger.severe(e.getMessage());
		}
		return commandeDetail;
	}

	public List<Commande> getListeCommandes() throws Exception {
		List<Commande> listeCommandes = new ArrayList<>();
		try (Connection cnx = AccesBase.getConnection()) {
			PreparedStatement cmd = cnx.prepareStatement(GET_LISTE);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				listeCommandes.add(itemBuilder(rs));
			}
		} catch (SQLException e) {
			logger.severe(e.getMessage());
		}
		return listeCommandes;
	}

	public Map<Employe, Integer> getNbCommandesParEmploye() throws Exception {
		Map<Employe, Integer> nbCommandes = new HashMap<>();
		try (Connection cnx = AccesBase.getConnection()) {
			// PreparedStatement cmd = cnx.prepareStatement(sql);
		} catch (SQLException e) {
			logger.severe(e.getMessage());
		}

		return nbCommandes;
	}

	private Commande itemBuilder(ResultSet rs) throws Exception {
		Commande commande = new Commande();
		try {
			commande.setId(rs.getInt(COL_IDCOMMANDE));

			Societe societe = new Societe();
			societe.setId(rs.getInt(COL_IDSOCIETE));
			societe.setNom(rs.getString(COL_NOM_SOCIETE));
			societe.setAdresse(rs.getString(COL_ADRESSE));

			Article article = new Article();
			article.setId(rs.getInt(COL_IDARTICLE));
			article.setLibelle(rs.getString(COL_LIBELLE));
			article.setPoids(rs.getFloat(COL_POIDSARTICLE));

			
			commande.setPoidsTotal(rs.getFloat(COL_POIDSTOTAL));
			commande.setStatut(ManipEnumStatut.StringToEnum(rs.getString(COL_STATUT)));
			commande.setDateCommande(ManipDate.dateSQLVersUtil(rs.getDate(COL_DATE)));

			Employe employe = new Employe();

			employe.setId(rs.getInt(COL_IDEMPLOYE));
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
