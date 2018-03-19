package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Food;


@Stateless
public class FoodDao extends AbstractDao<Food, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public FoodDao(){
		super(Food.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}
