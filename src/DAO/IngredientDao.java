package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Ingredient;


@Stateless
public class IngredientDao extends AbstractDao<Ingredient, Integer>{

    @PersistenceContext
    EntityManager em;

    public IngredientDao(){
        super(Ingredient.class);
    }

    @Override
    public EntityManager em() {
        return em;
    }

}