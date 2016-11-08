package fr.entities;

public class User {
	private int id;
	private String pseudo;
	private String password;
	
	private Backup backup;
	
	public User(String pseudo, String password) {
		super();
		this.pseudo = pseudo;
		this.password = password;
	}

	public User(int id, String pseudo, String password, Backup backup) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.password = password;
		this.backup = backup;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Backup getBackup() {
		return backup;
	}

	public void setBackup(Backup backup) {
		this.backup = backup;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", password=");
		builder.append(password);
		builder.append(", backup=");
		builder.append(backup);
		builder.append("]");
		return builder.toString();
	}
	
	
}
