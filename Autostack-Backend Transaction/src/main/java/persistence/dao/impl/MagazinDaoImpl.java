package persistence.dao.impl;

import persistence.dao.MagazinDao;
import persistence.entities.Magazin;

import javax.ejb.EJBException;
import javax.ejb.Stateless;

import javax.persistence.Query;
import java.util.List;

@Stateless
public class MagazinDaoImpl extends AbstractDao implements MagazinDao {

    @Override
    public List<Magazin> getParts() {

        Query query = (Query) getSession().createQuery("from Magazin");

        return query.getResultList();
    }

    @Override
    public int createNewPart(Magazin magazin) {
        return (int) getSession().save(magazin);
    }

    @Override
    public void updatePart(Magazin magazin) {

        getSession().update(magazin);
    }

    public void deletePart(int idPart) {

        Magazin magazin = getSession().get(Magazin.class, idPart);
        delete(magazin);
        throw new EJBException();
    }

}
