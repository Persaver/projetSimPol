package fr.entities;

import java.io.Serializable;

public class Construction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String designation;
	private int h;
	private int w;
	
	private Categorie categorie;

	public Construction() {
	}
	
	public Construction(String designation, int h, int w, Categorie categorie) {
		super();
		this.designation = designation;
		this.h = h;
		this.w = w;
		this.categorie = categorie;
	}
	
	public Construction(int id, String designation, int h, int w) {
		super();
		this.id = id;
		this.designation = designation;
		this.h = h;
		this.w = w;
	}
	
	public Construction(int id, String designation, int h, int w, Categorie categorie) {
		super();
		this.id = id;
		this.designation = designation;
		this.h = h;
		this.w = w;
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Construction [id=");
		builder.append(id);
		builder.append(", designation=");
		builder.append(designation);
		builder.append(", h=");
		builder.append(h);
		builder.append(", w=");
		builder.append(w);
		builder.append(", categorie=");
		builder.append(categorie);
		builder.append("]");
		return builder.toString();
	}
	
}
