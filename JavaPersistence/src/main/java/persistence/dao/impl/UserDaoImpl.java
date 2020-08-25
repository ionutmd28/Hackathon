package persistence.dao.impl;

import persistence.dao.UserDao;
import persistence.entities.Car;
import persistence.entities.User;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

@Stateless
public class UserDaoImpl extends AbstractDao implements UserDao {

    @PersistenceContext(unitName = "ionut", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    //Named Query
    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createNamedQuery("User.getAll", User.class);

        return (List<User>) query.getResultList();
    }

    @Override
    public int createNewUser(User user) {
        return (int) getSession().save(user);
    }

    @Override
    public void deleteUser(int userId) {
        User user = getSession().get(User.class, userId);
        delete(user);
    }

    //Criteria Query
    @Override
    public int resetPassword(User user) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaUpdate<User> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(User.class);

        Root<User> root = criteriaUpdate.from(User.class);

        System.out.println(user.getPassword() + user.getIdUser());
        criteriaUpdate.set("password", user.getPassword());
        criteriaUpdate.where(criteriaBuilder.equal(root.get("id_user"), user.getIdUser()));

        this.entityManager.createQuery(criteriaUpdate).executeUpdate();

        return user.getIdUser();
    }

    @Override
    public int addCarToUser(int carId, int userId) {
        User user = getSession().get(User.class, userId);
        Car car = getSession().get(Car.class, carId);

        user.getCarList().add(car);

        getSession().saveOrUpdate(user);

        return carId;
    }

    @Override
    public List<Car> getCarsFromUser(int userId) {
        User user = getSession().get(User.class, userId);

        return user.getCarList();
    }

}
