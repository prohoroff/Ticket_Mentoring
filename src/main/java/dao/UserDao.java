package dao;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

@Repository
public class UserDao {

    private final List<User> users;

    public UserDao(List<User> users) {
        this.users = users;
    }

    public User getUserById(long userId) {
        return null;
    }

    public User getUserByEmail(String email) {
        return null;
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return users.stream().filter(o -> o.getName().equals(name)).collect(Collectors.toList());
    }

    public User createUser(User user) {
        return null;
    }

    public User updateUser(User user) {
        return null;
    }

    public boolean deleteUser(long userId) {
        return false;
    }
}
