package persistence.dao;

import persistence.entities.Magazin;

import java.util.List;

public interface MagazinDao {

    List<Magazin> getParts();

    int createNewPart(Magazin magazin);

    void updatePart(Magazin magazin);

    void deletePart(int idPart);
}
