package fr.db;

import java.sql.Connection;
import java.util.ArrayList;

public class AccessDB {
	private static AccessDB adb;
	private static final int MAXCNX = 10;
	private ArrayList<Connection> cnx= new ArrayList<>();
	private AccessDB(){

	}
	public static AccessDB getInstance(){
		if(adb != null){
			adb = new AccessDB();
		}
		return new AccessDB();
	}
}
