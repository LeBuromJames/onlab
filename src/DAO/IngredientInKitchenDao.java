package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Food;
import com.jpa.entities.IngredientInKitchen;
import com.jpa.entities.NeededIngredient;
import com.jpa.entities.WishedIngredient;


@Stateless
public class IngredientInKitchenDao extends AbstractDao<IngredientInKitchen, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public IngredientInKitchenDao(){
		super(IngredientInKitchen.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}
