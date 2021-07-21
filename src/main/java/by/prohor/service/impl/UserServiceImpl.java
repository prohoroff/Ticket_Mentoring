package by.prohor.service.impl;


import by.prohor.dao.UserAccountDao;
import by.prohor.dao.UserDao;
import by.prohor.model.User;
import by.prohor.model.UserAccount;
import by.prohor.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final UserAccountDao userAccountDao;

    public UserServiceImpl(UserDao userDao, UserAccountDao userAccountDao) {
        this.userDao = userDao;
        this.userAccountDao = userAccountDao;
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
    @Transactional
    public User createUser(User user) {
        User save = userDao.save(user);
        UserAccount userAccount = new UserAccount();
        userAccount.setId(save.getId());
        userAccount.setPrepayment(0.0);
        userAccount.setUser(save);
        userAccountDao.save(userAccount);
        return save;
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return null;
    }

    @Override
    @Transactional
    public void deleteUser(long userId) {
        userDao.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public double findBalanceByUserId(long userId) {
        return userAccountDao.findPrepaymentById(userId);
    }

    @Override
    public void spendCash(int id, String cash) {
        Optional<UserAccount> byId = userAccountDao.findById((long) id);
        if (byId.isPresent()) {
            UserAccount userAccount = byId.get();
            Double prepayment = userAccount.getPrepayment();
            prepayment -= Double.parseDouble(cash);
            userAccount.setPrepayment(prepayment);
            userAccountDao.save(userAccount);
        }
    }

    @Override
    public void addMoney(int id, String add) {
        Optional<UserAccount> byId = userAccountDao.findById((long) id);
        if (byId.isPresent()) {
            UserAccount userAccount = byId.get();
            Double prepayment = userAccount.getPrepayment();
            if (prepayment == null) {
                prepayment = Double.parseDouble(add);
                userAccount.setPrepayment(prepayment);
                userAccountDao.save(userAccount);
                return;
            }
            prepayment += Double.parseDouble(add);
            userAccount.setPrepayment(prepayment);
            userAccountDao.save(userAccount);
        }
    }

    @Override
    public List<UserAccount> findAllPrepayment() {
        return userAccountDao.findAll();
    }
}
