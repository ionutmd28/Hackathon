package persistence.dao.impl;

import persistence.dao.CarDao;
import persistence.entities.Car;
import persistence.entities.User;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CarDaoImpl extends AbstractDao implements CarDao {

    @Override
    public List<Car> getAllCars() {
        Query query = (Query) getSession().createQuery("from Car");

        return query.getResultList();
    }

    @Override
    public int createNewCar(Car car) {
        return (int) getSession().save(car);
    }

    @Override
    public void deleteCar(int carId) {
        Car car = getSession().get(Car.class, carId);
        delete(car);
    }
}
