package fr.eniecole.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.xml.internal.ws.server.sei.ValueGetter;

import fr.eniecole.bean.Employe;
import fr.eniecole.utils.AccesBase;


public class EmployeDAO {
	
	public static void ajouter(Employe employe) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("insert into Employes(nom, prenom, role, mail,password) values (?,?,?,?,?)");
			rqt.setString(1, employe.getNom());
			rqt.setString(2, employe.getPrenom());
			rqt.setString(3, employe.getRole().toString());
			rqt.setString(4, employe.getEmail());
			rqt.setString(5, employe.getPassword());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	/**
	 * Méthode qui permet de supprimer une formation dans la BD.
	 * @param formation Bean formation à supprimer.
	 * @throws SQLException Exception de type SQL.
	 */
	public static void supprimer(Employe employe) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("delete from Employes where idEmploye = ?");
			rqt.setInt(1, employe.getId());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	/**
	 * Méthode qui permet de modifier une formation dans la BD.
	 * @param formation Bean formation à modifer.
	 * @throws SQLException Exception de type SQL.
	 */
	public static void modifier(Employe employe) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("update formations set nom=?, prenom=?, role=?, mail=?,password=?");
			rqt.setString(1, employe.getNom());
			rqt.setString(2, employe.getPrenom());
			rqt.setString(3, employe.getRole().toString());
			rqt.setString(4, employe.getEmail());
			rqt.setString(5, employe.getPassword());

			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	/**
	 * Méthode qui permet de rechercher une formation dans la BD.
	 * @param formation Bean formation à rechercher.
	 * @throws SQLException Exception de type SQL.
	 */
	public static Employe rechercher(Employe employe) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("select * from formations where idEmploye = ?");
			rqt.setInt(1, employe.getId());
			rs=rqt.executeQuery();
			while (rs.next()){
				employe.setNom(rs.getString("nom"));
				employe.setPrenom(rs.getString("prenom"));
				employe.setRole(Enum.valueOf(null,rs.getString("role")));
				employe.setEmail(rs.getString("mail"));
				employe.setPassword(rs.getString("password"));
				
			}
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return employe;
	}
	
	/**
	 * Retourne la liste des formations présente dans la BD.
	 * @return La liste peut être vide mais jamais <code>null</code>
	 * @throws SQLException Exception de type SQL.
	 */
	public static ArrayList<Employe> lister() throws SQLException{
		Connection cnx=null;
		Statement rqt=null;
		ResultSet rs=null;
		ArrayList<Employe> listeEmployes = new ArrayList<Employe>();
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.createStatement();			
			rs=rqt.executeQuery("select * from Employes");
			Employe employe;
			while (rs.next()){
				employe = new Employe(
									rs.getInt("idEmploye"),
									rs.getString("nom"),
									rs.getString("prenom"),
									Enum.valueOf(null, rs.getString("role")),
									rs.getString("mail"),
									rs.getString("password")
						);
				listeEmployes.add(employe);				
			}
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return listeEmployes;
	}

}
