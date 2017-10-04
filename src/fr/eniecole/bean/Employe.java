package fr.eniecole.bean;

import java.io.Serializable;

public class Employe implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nom;
	private String prenom;
	private Employe_Manager_Enum role;
	private String email;
	private String password;
	
	
	
	public Employe() {
		super();
	}
	
	
	public Employe(int id, String nom, String prenom, Employe_Manager_Enum role, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.email = email;
		this.password = password;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Employe_Manager_Enum getRole() {
		return role;
	}
	public void setRole(Employe_Manager_Enum role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", prenom=" + prenom + ", role=" + role + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
	
	

}
