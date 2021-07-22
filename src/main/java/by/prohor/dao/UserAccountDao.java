package by.prohor.dao;

import by.prohor.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Artsiom Prokharau 21.07.2021
 */


public interface UserAccountDao extends JpaRepository<UserAccount, Long> {
    double findPrepaymentById(long userId);
}
