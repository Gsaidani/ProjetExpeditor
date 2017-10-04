package fr.eniecole.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eniecole.bean.Article;
import fr.eniecole.utils.AccesBase;

public class ArticleDAO {

	public Article getArticle(int id){
		Article art = null;
		ResultSet rs=null;
		
		try(Connection cnx=AccesBase.getConnection()){
			PreparedStatement rqt = cnx.prepareStatement("select * from Articles where idArticle = ?");
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				art = itemBuilder(rs);
			}
			
			return art;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Article> getListeArticles(){
		List<Article> listeArticles = new ArrayList<Article>();
		Article art = null;
		ResultSet rs = null;
		
		try(Connection cnx = AccesBase.getConnection()){
			PreparedStatement rqt = cnx.prepareStatement("Select * from Articles");
			rs = rqt.executeQuery();
			while (rs.next()){
				art = itemBuilder(rs);
				listeArticles.add(art);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return listeArticles;
	}
	
	public void addArticle(Article article){
		try (Connection cnx = AccesBase.getConnection()){
			PreparedStatement rqt = cnx.prepareStatement("insert into Article (libelle, poidsArticle, quantite) "
					+  "values (?,?,?)");
			rqt.setString(1, article.getLibelle());
			rqt.setFloat(2, article.getPoids());
			rqt.setInt(3, article.getQuantite());
			rqt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateArticle(Article article){
		try (Connection cnx = AccesBase.getConnection()){
			PreparedStatement rqt = cnx.prepareStatement("update Articles set libelle = ?, poidsArticle= ?, "
					+ "quantite = ? where id = ?");
			rqt.setString(1, article.getLibelle());
			rqt.setFloat(2, article.getPoids());
			rqt.setInt(3, article.getQuantite());
			rqt.setInt(4, article.getId());
			rqt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteArticle(Article article){
		try (Connection cnx = AccesBase.getConnection()){
			PreparedStatement rqt = cnx.prepareStatement("delete from Articles where idArticle = ?");
			rqt.setInt(1, article.getId());
			rqt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public Article itemBuilder(ResultSet rs) throws Exception{
		Article art = new Article();
		art.setId(rs.getInt("idArticle"));
		art.setLibelle(rs.getString("libelle"));
		art.setPoids(rs.getFloat("poidsArticle"));
		art.setQuantite(rs.getInt("quantite"));
		
		return art;
	}
}
