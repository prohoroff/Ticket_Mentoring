import facade.BookingFacadeImpl;
import model.Ticket;
import model.User;
import model.UserImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("configSpring.xml");
        BookingFacadeImpl bean = applicationContext.getBean("facadeImpl",BookingFacadeImpl.class);
//        Get from list Event
        System.out.println(bean.getEventById(2));

//        Get value from Map Ticket
        User user = new UserImpl();
        user.setId(1);
        System.out.println(bean.getBookedTickets(user,1,1));

        System.out.println(bean.bookTicket(2, 2, 21, Ticket.Category.PREMIUM));

//        Get value from list User
        System.out.println(bean.getUsersByName("Alex", 1, 1));

//

    }
}
