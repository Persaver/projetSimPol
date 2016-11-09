package fr.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fr.db.AccessDB;

public abstract class DAO<T>{
	public Connection connect = null;
			
	
	public DAO(){
		try {
			this.connect = AccessDB.seConnecter();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println("Connecté");
	};
	public abstract T get(int id);
	public abstract void save(T element);
	public abstract void delete(int id);
	public abstract void update(T element);
	public abstract List<T> getAll();
}
