package fr.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.entities.Categorie;
import fr.entities.Construction;

public class ConstructionDAO extends DAO<Construction>{

	@Override
	public Construction get(int id) {
		ResultSet result;
		try 
		{
			PreparedStatement prepare = this.connect.prepareStatement("Select * from construction where id = ?");
			prepare.setInt(1, id);
			result = prepare.executeQuery();
			if(result != null){
				result.first();
				Construction construction = new Construction(result.getInt("id"), result.getString("designation"), result.getInt("h"), result.getInt("w"));
				return construction;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(Construction element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Construction element) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Construction> getAll() {
		ResultSet result;
		List<Construction> constructions = new ArrayList<Construction>();
		try {
			result = this.connect.createStatement().executeQuery("Select * from construction inner join categorie on construction.categorie = categorie.id ");
			while(result.next()){
				Categorie categorie = new Categorie(result.getInt("categorie.id"), result.getString("libeele"));
				Construction construction = new Construction(result.getInt("id"), result.getString("designation"), result.getInt("h"), result.getInt("w"), categorie);
				constructions.add(construction);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return constructions ;
		// TODO Auto-generated method stub
		
	}
	
}
