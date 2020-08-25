package persistence.dao;

import persistence.entities.Car;
import persistence.entities.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    int resetPassword(User user);

    int addCarToUser(int carId, int userId);

    List<Car> getCarsFromUser(int userId);

    int createNewUser(User user);

    void deleteUser(int userId);
}
