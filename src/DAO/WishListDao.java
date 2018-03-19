package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.WishList;


@Stateless
public class WishListDao extends AbstractDao<WishList, Integer>{

    @PersistenceContext
    EntityManager em;

    public WishListDao(){
        super(WishList.class);
    }

    @Override
    public EntityManager em() {
        return em;
    }

}