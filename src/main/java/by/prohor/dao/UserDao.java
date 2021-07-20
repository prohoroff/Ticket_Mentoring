package by.prohor.dao;

import by.prohor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * * Created by Artsiom Prokharau 08.07.2021
 */


public interface UserDao extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    User findByEmail(String email);
}
