package DAO;

import java.util.List;

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
    
    /*public List<Kitchen> getAllVersionsForFileId(String userId) {

        return em.createQuery("select k from Kitchen k where k.userId=:id", Kitchen.class)
                .setParameter("id", userId).getResultList();

    }*/

}