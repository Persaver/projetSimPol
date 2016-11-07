package fr.DAO;

public abstract class DAO<T>{
//	private AccessDB abd = null;
//	private Connexion cnx = null;
	
	
	public abstract T get(int id);;
	
	public abstract void save(T element);
	public abstract void delete(int id);
	
	public abstract void update(T element);
}
