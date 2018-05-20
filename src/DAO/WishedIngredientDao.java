package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Food;
import com.jpa.entities.NeededIngredient;
import com.jpa.entities.WishedIngredient;


@Stateless
public class WishedIngredientDao extends AbstractDao<WishedIngredient, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public WishedIngredientDao(){
		super(WishedIngredient.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}
