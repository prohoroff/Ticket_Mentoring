package by.prohor.service.impl;


import by.prohor.model.Category;
import by.prohor.model.Event;
import by.prohor.model.Ticket;
import by.prohor.model.User;
import by.prohor.service.TicketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

@Service
@Transactional(readOnly = true)
public class TicketServiceImpl implements TicketService {

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return null;
    }

    @Override
    @Transactional
    public boolean cancelTicket(long ticketId) {
        return false;
    }
}
