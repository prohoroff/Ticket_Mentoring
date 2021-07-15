package by.prohor.service.impl;


import by.prohor.dao.UserDao;
import by.prohor.model.User;
import by.prohor.service.UserService;
import by.prohor.service.parser.ConverterXml;
import by.prohor.service.parser.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */


public class UserServiceImpl implements UserService {

    UserDao userDao;

    @Autowired
    private ConverterXml converter;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(long userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userDao.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userDao.deleteUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void preloadUsers() {
        UserDto userDto = converter.XMLToObj();
        userDao.preloadUsers(userDto.getUserList());
    }
}
