package business.impl;

import business.MagazinManager;
import persistence.dao.MagazinDao;
import persistence.entities.Magazin;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class MagazinManagerImpl implements MagazinManager {

    @Resource
    TransactionSynchronizationRegistry tsr;

    @Inject
    MagazinDao magazinDao;

    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public List<Magazin> getParts() {
        System.out.println("Hallo from: " + tsr.getTransactionStatus());
        System.out.println("Hallo from: " + tsr.getTransactionKey());
        Magazin magazin = new Magazin();
        magazin.setName("Required");
        magazin.setDescription("Required");
        magazin.setPrice(99);
        magazinDao.createNewPart(magazin);

//        magazinDao.deletePart(1);
        return magazinDao.getParts();
    }

    @Override
    public int createNewPart(Magazin magazin) {
        return magazinDao.createNewPart(magazin);
    }

    @Override
    public void updatePart(Magazin magazin) {
        magazinDao.updatePart(magazin);
    }

    @Override
    public void deletePart(int idPart) {
        magazinDao.deletePart(idPart);
    }

}
