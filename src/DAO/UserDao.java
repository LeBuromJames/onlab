package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.User;


@Stateless
public class UserDao extends AbstractDao<User, Integer> {

    @PersistenceContext
    EntityManager em;

    public UserDao() {
        super(User.class);
    }

    @Override
    public EntityManager em() {
        return em;
    }

}