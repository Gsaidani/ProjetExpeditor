package fr.eniecole.bean;

import java.io.Serializable;

public class Article implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String libelle;
	private float poids;
	private int quantite;
	
	
	public Article() {
	}
	
	public Article(int id, String libelle, float poids, int quantite) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.poids = poids;
		this.quantite = quantite;
	}


	public int getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}
	public float getPoids() {
		return poids;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setPoids(float poids) {
		this.poids = poids;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [id=");
		builder.append(id);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", poids=");
		builder.append(poids);
		builder.append(", quantite=");
		builder.append(quantite);
		builder.append("]");
		return builder.toString();
	}
	
}
