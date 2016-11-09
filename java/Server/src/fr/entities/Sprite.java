package fr.entities;

import java.util.Arrays;

public class Sprite {
	private int id;
	private String url;
	private String name;
	private int[] coordonnées;
	
	private Construction construction;
	
	public Sprite(String url, String name, int[] coordonnées) {	
		this.url = url;
		this.name = name;
		this.coordonnées = coordonnées;
	}
	
	public Sprite(int id, String url, String name, int[] coordonnées) {
		this.id = id;
		this.url = url;
		this.name = name;
		this.coordonnées = coordonnées;
	}
	
	
	public Sprite(int id, String url, String name, int[] coordonnées, Construction construction) {
		this.id = id;
		this.url = url;
		this.name = name;
		this.coordonnées = coordonnées;
		this.construction = construction;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getCoordonnées() {
		return coordonnées;
	}

	public void setCoordonnées(int[] coordonnées) {
		this.coordonnées = coordonnées;
	}

	public Construction getConstruction() {
		return construction;
	}

	public void setConstruction(Construction construction) {
		this.construction = construction;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sprite [id=");
		builder.append(id);
		builder.append(", url=");
		builder.append(url);
		builder.append(", name=");
		builder.append(name);
		builder.append(", coordonnées=");
		builder.append(Arrays.toString(coordonnées));
		builder.append(", construction=");
		builder.append(construction);
		builder.append("]");
		return builder.toString();
	}
	
}
