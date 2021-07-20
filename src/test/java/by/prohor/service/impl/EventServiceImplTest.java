package by.prohor.service.impl;

import by.prohor.dao.EventDao;
import by.prohor.model.Event;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    @InjectMocks
    EventServiceImpl eventService;

    @Mock
    EventDao eventDao;

    @Test
    void getEventById() {
        Event event = new Event("Mock", new Date("12/12/2012"));

        when(eventDao.findById(any(Long.class))).thenReturn(Optional.of(event));

        Event eventById = eventService.getEventById(0);
        assertEquals(eventById, event);
    }

    @Test
    void getEventsByTitle() {
        Event event1 = new Event("Mock", new Date("12/12/2012"));
        Event event2 = new Event("Mock", new Date("12/12/2012"));
        List<Event> list = Arrays.asList(event1, event2);

        when(eventDao.findEventByTitle(any())).thenReturn(list);

        List<Event> mock = eventService.getEventsByTitle("Mock", 1, 1);
        assertEquals(list.size(), mock.size());
    }

    @Test
    void getEventsForDay() {
        Event event1 = new Event("Mock", new Date("12/12/2012"));
        Event event2 = new Event("Mock", new Date("12/12/2012"));
        List<Event> list = Arrays.asList(event1, event2);

        when(eventDao.findEventByDate(any())).thenReturn(list);

        List<Event> mock = eventService.getEventsForDay(new Date("12/12/2012"), 1, 1);
        assertEquals(list.size(), mock.size());
    }

    @Test
    void createEvent() {
        Event event = new Event("Mock", new Date("12/12/2012"));
        when(eventDao.save(any())).thenReturn(event);
        assertEquals(eventService.createEvent(event), event);

    }
}