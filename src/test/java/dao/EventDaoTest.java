package dao;

import model.Event;
import model.EventImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config.xml"})
class EventDaoTest {

    @Autowired
    private EventDao eventDao;

    List<Event> list = new ArrayList<>();

    @Test
    void getEventById() {
        Event event = new EventImpl((long) 1, "Test", new Date("12/12/2012"));
        eventDao.createEvent(event);
        assertEquals(event, eventDao.getEventById(event.getId()));
    }

    @Test
    void getEventsByTitle() {
        Event event1 = new EventImpl((long) 1, "Test", new Date("12/12/2012"));
        Event event2 = new EventImpl((long) 2, "Test", new Date("12/12/2012"));
        eventDao.createEvent(event1);
        eventDao.createEvent(event2);
        assertEquals(2, eventDao.getEventsByTitle("Test", 1, 1).size());
    }

    @Test
    void getEventsByTitleReturnEmptyList() {
        assertTrue(eventDao.getEventsByTitle("Test",1,1).isEmpty());
    }

    @Test
    void getEventsForDay() {
        Event event = new EventImpl((long) 1, "Test", new Date("12/12/2012"));
        eventDao.createEvent(event);
        Date date = new Date("12/12/2012");
        assertEquals(1, eventDao.getEventsForDay(date, 1, 1).size());
    }

    @Test
    void createEvent() {
        Event event = new EventImpl((long) 1, "Test", new Date("12/12/2012"));
        assertEquals(0,eventDao.sizeEvent());
        eventDao.createEvent(event);
        assertEquals(1,eventDao.sizeEvent());
    }

    @Test
    void updateEvent() {
        


        Event event = new EventImpl((long) 1, "Test", new Date("12/12/2012"));
        list.add(event);
        list.add(event);
        list.add(event);

        event.setTitle("Update");
        Event event1 = list.get(0);
        System.out.println(event1);

        List<Event> eventById = eventDao.getEventsByTitle("Test",1,1);
        System.out.println(eventById);
        assertEquals(event, eventById);

    }
//
//    public boolean deleteEvent(long eventId) {
//        Event event = events.get((int) eventId);
//        return events.remove(event);
//    }

}