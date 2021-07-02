package model;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

public class TicketImpl implements Ticket {

    private Long id;
    private Long eventId;
    private Long UserId;
    private Category category;
    private Integer place;

    public TicketImpl(Long id, Long eventId, Long userId, Category category, Integer place) {
        this.id = id;
        this.eventId = eventId;
        UserId = userId;
        this.category = category;
        this.place = place;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    @Override
    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "TicketImpl{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", UserId=" + UserId +
                ", category=" + category +
                ", place=" + place +
                '}';
    }
}
