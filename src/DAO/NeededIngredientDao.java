package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Food;
import com.jpa.entities.NeededIngredient;


@Stateless
public class NeededIngredientDao extends AbstractDao<NeededIngredient, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public NeededIngredientDao(){
		super(NeededIngredient.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}
