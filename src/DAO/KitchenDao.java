package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Kitchen;


@Stateless
public class KitchenDao extends AbstractDao<Kitchen, Integer>{

    @PersistenceContext
    EntityManager em;

    public KitchenDao(){
        super(Kitchen.class);
    }

    @Override
    public EntityManager em() {
        return em;
    }

}