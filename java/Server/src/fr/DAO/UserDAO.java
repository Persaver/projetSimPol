package fr.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.entities.User;

public class UserDAO extends DAO<User>{

	@Override
	public User get(int id) {
		ResultSet result;
		try {
			PreparedStatement prepare = this.connect.prepareStatement("SELECT * FROM user WHERE id =?");
			prepare.setInt(1, id);
			result = prepare.executeQuery();
			if(result!= null){
				User user = new User(result.getInt("id"), result.getString("pseudo"), result.getString("password"));
				return user;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
