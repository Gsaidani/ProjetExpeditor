package fr.eniecole.dal;
import fr.eniecole.bean.Societe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SocieteDAO {

	Logger logger = Logger.getLogger(this.getClass().getName());
	private final static String COL_NOM="nom";
	private final static String COL_ID="id";
	private final static String COL_ADRESSE="adresse";
	
	
	
	/**
	 * 
	 */
	public Societe itemBuilder(ResultSet rs) throws SQLException {
	Societe societe = new Societe();
	societe.setId(rs.getInt(COL_ID));
	societe.setAdresse(rs.getString(COL_ADRESSE));
	societe.setNom(rs.getString(COL_NOM));
	
	return societe;
	
	}
}
