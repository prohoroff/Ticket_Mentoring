package dao;

import model.Event;
import model.Ticket;
import model.User;

import java.util.List;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

public class TicketDao {
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return null;
    }

    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return null;
    }

    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return null;
    }

    public boolean cancelTicket(long ticketId) {
        return false;
    }
}
