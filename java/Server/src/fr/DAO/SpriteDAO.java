package fr.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.entities.Sprite;

public class SpriteDAO extends DAO<Sprite>{

	@Override
	public Sprite get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Sprite element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Sprite element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Sprite> getAll() {
		ResultSet result;
		List<Sprite> sprites = new ArrayList<Sprite>();
		try {
			result = this.connect.createStatement().executeQuery("SELECT * FROM sptrite");
			if(result!=null){
				while(result.next()){
					Sprite sprite = new Sprite(result.getInt("id"), result.getString("url"), result.getString("name"), result.getInt("x"), result.getInt("y"), result.getInt("w"), result.getInt("h"));
					sprites.add(sprite);
				}
			}
		}catch (SQLException e){
			
		}
		// TODO Auto-generated method stub
		return null;
	}

}
