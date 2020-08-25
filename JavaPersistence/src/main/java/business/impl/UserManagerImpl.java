package business.impl;

import business.UserManager;
import persistence.dao.UserDao;
import persistence.entities.Car;
import persistence.entities.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UserManagerImpl implements UserManager {

    @Inject
    UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public int resetPassword(User user) {
        return userDao.resetPassword(user);
    }

    @Override
    public int addCarToUser(int carId, int userId) {
        return userDao.addCarToUser(carId, userId);
    }

    @Override
    public List<Car> getCarsFromUser(int userId) {
        return userDao.getCarsFromUser(userId);
    }

    @Override
    public int createNewUser(User user) {
        return userDao.createNewUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }
}
