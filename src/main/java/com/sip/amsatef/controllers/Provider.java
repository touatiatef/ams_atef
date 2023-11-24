package com.sip.amsatef.controllers;

public class Provider {

	private int id;
	private String nom;
	private String addresse ;
	private String mobile;
	
	
	
	public Provider(int id,String nom, String addresse, String mobile) {
		super();
		this.id=id;
		this.nom = nom;
		this.addresse = addresse;
		this.mobile = mobile;
	}
	
	public Provider(String nom, String addresse, String mobile) {
		super();
		this.nom = nom;
		this.addresse = addresse;
		this.mobile = mobile;
	}
	
	public Provider() {
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
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	@Override
	public String toString() {
		return "Provider [id=" + id + ", nom=" + nom + ", addresse=" + addresse + ", mobile=" + mobile + "]";
	}


	
	
}
