package dao;

import model.Event;
import model.Ticket;
import model.TicketImpl;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

@Repository
public class TicketDao {

    @Autowired
    private Map<String, Ticket> tickets;

    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        TicketImpl ticket = new TicketImpl(eventId, userId, category, place);
        ticket.setId(4);
        tickets.put("tickets: " + ticket.getId(), ticket);
        System.out.println(tickets);
        return ticket;
    }

    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        long id = user.getId();
        return tickets.values().stream().filter(o -> o.getUserId() == id).collect(Collectors.toList());
    }

    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return null;
    }

    public boolean cancelTicket(long ticketId) {
        return false;
    }
}
