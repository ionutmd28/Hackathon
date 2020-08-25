package persistence.dao;

import persistence.entities.Car;
import persistence.entities.User;

import java.util.List;

public interface CarDao {

    List<Car> getAllCars();

    int createNewCar(Car car);

    void deleteCar(int carId);
}
