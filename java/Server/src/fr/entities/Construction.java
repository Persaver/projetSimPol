package fr.entities;

import java.io.Serializable;
import java.util.Arrays;

public class Construction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String designation;
	private int h;
	private int w;
	private String url;
	private int[] coordonnées;
	
	
	private Categorie categorie;

	public Construction() {
	}
	
	public Construction(String designation, int h, int w, String url, int[] coordonnées, Categorie categorie) {
		this.designation = designation;
		this.h = h;
		this.w = w;
		this.url = url;
		this.coordonnées = coordonnées;
		this.categorie = categorie;
	}
	
	public Construction(int id, String designation, int h, int w, String url, int[] coordonnées, Categorie categorie) {
		this.id = id;
		this.designation = designation;
		this.h = h;
		this.w = w;
		this.url = url;
		this.coordonnées = coordonnées;
		this.categorie = categorie;
	}

	public Construction(String designation, int h, int w, String url, int[] coordonnées) {
		this.designation = designation;
		this.h = h;
		this.w = w;
		this.url = url;
		this.coordonnées = coordonnées;
	}

	public Construction(int id, String designation, int h, int w, String url, int[] coordonnées) {
		this.id = id;
		this.designation = designation;
		this.h = h;
		this.w = w;
		this.url = url;
		this.coordonnées = coordonnées;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int[] getCoordonnées() {
		return coordonnées;
	}

	public void setCoordonnées(int[] coordonnées) {
		this.coordonnées = coordonnées;
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
		builder.append(", url=");
		builder.append(url);
		builder.append(", coordonnées=");
		builder.append(Arrays.toString(coordonnées));
		builder.append(", categorie=");
		builder.append(categorie);
		builder.append("]");
		return builder.toString();
	}
	
}
