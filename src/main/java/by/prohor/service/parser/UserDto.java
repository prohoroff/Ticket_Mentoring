package by.prohor.service.parser;

import by.prohor.model.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Artsiom Prokharau 15.07.2021
 */

@XmlRootElement(name = "users")
public class UserDto {

    private List<User> userList;

    @XmlElement(name = "user")
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
