package business.impl;

import business.CarManager;
import persistence.dao.CarDao;
import persistence.entities.Car;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CarManagerImpl implements CarManager {
    @Inject
    CarDao carDao;

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    @Override
    public int createNewCar(Car car) {
        return carDao.createNewCar(car);
    }

    @Override
    public void deleteCar(int carId) {
        carDao.deleteCar(carId);
    }
}
