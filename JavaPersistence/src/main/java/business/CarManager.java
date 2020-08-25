package business;

import persistence.entities.Car;

import java.util.List;

public interface CarManager {

    List<Car> getAllCars();

    int createNewCar(Car car);

    void deleteCar(int carId);
}
