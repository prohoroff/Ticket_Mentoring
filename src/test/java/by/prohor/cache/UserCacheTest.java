package by.prohor.cache;

import by.prohor.facade.BookingFacade;
import by.prohor.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Artsiom Prokharau 22.07.2021
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config.xml"})
@Transactional
public class UserCacheTest {


    @Autowired
    BookingFacade bookingFacade;


    @Test
    void cacheUserGetAll() {
        User user = new User("test","Test@email.com");
        bookingFacade.createUser(user);

        bookingFacade.getUserById(user.getId());
        System.out.println("----------------------------------------------------------------");
        bookingFacade.getUserById(user.getId());
        System.out.println("----------------------------------------------------------------");
        bookingFacade.getUserById(user.getId());
        System.out.println("----------------------------------------------------------------");
    }
}
