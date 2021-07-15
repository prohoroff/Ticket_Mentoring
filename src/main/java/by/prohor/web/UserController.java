package by.prohor.web;

import by.prohor.facade.BookingFacade;
import by.prohor.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Artsiom Prokharau 09.07.2021
 */


@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    BookingFacade bookingFacade;

    @GetMapping("/")
    public String start(Model model) {
        List<User> allUsers = bookingFacade.getAllUsers();
        LOGGER.debug("get all users => {}", allUsers);
        model.addAttribute("allUser", allUsers);
        LOGGER.info("Method start. UserController (-- / --)");
        return "users";
    }

    @GetMapping("/create")
    public String name(@RequestParam("name") String name, @RequestParam("email") String email) {
        LOGGER.debug("Create user with name ({}) and email ({})", name, email);
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        bookingFacade.createUser(user);
        LOGGER.info("Method start. UserController (-- /create --)");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        LOGGER.debug("Delete user with id ({})", id);
        bookingFacade.deleteUser(id);
        LOGGER.info("Method start. UserController (-- /delete/{id} --)");
        return "redirect:/";
    }

    @GetMapping("/new")
    public String create() {
        LOGGER.info("Method start. UserController (-- /new --)");
        return "user_add";
    }

}
