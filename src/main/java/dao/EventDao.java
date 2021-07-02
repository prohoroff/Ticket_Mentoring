package dao;

import model.Event;

import java.util.Date;
import java.util.List;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

public class EventDao {

    public Event getEventById(long eventId) {
        return null;
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return null;
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return null;
    }

    public Event createEvent(Event event) {
        return null;
    }

    public Event updateEvent(Event event) {
        return null;
    }

    public boolean deleteEvent(long eventId) {
        return false;
    }
}
