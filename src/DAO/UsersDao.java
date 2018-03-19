package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Users;


@Stateless
public class UsersDao extends AbstractDao<Users, Integer> {

    @PersistenceContext
    EntityManager em;

    public UsersDao() {
        super(Users.class);
    }

    @Override
    public EntityManager em() {
        return em;
    }

}