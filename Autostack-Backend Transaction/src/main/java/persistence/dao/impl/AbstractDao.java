package persistence.dao.impl;

import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateless
public abstract class AbstractDao {

    @PersistenceContext(unitName = "ionut12", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    protected Session getSession() {
        final Session session = entityManager.unwrap(Session.class);
        return session;
    }

    public void persist(Object entity) {
        getSession().persist(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }

}
