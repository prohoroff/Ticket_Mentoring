package model;

import java.util.Date;

/**
 * Created by Artsiom Prokharau 02.07.2021
 */

public class EventImpl implements Event {

    private long Id;
    private String title;
    private Date date;

    public EventImpl(Long id, String title, Date date) {
        Id = id;
        this.title = title;
        this.date = date;
    }

    @Override
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EventImpl{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
