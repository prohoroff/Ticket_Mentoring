package by.prohor.service.impl;


import by.prohor.dao.UserDao;
import by.prohor.model.User;
import by.prohor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(long userId) {
        return userDao.findById(userId).get();
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userDao.findByName(name);
    }

    @Override
    public User createUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(long userId) {
        userDao.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

}
