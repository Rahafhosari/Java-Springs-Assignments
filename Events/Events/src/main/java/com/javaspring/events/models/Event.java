package com.javaspring.events.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @Future(message = "We don't have a time Machine..Event must not be in the past!")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date eventDate;

    @NotEmpty
    private String city;
    private String state;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy = "event",fetch=FetchType.LAZY)
    private List<Message> messages;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User planner;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name="users_events",
            joinColumns = @JoinColumn(name="event_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private List<User> attendees;

    public Event () {}

    public Event(String name,Date eventDate, String city, String state, List<Message> messages, User planner, List<User> attendees) {
        this.name = name;
        this.eventDate = eventDate;
        this.city = city;
        this.state = state;
        this.messages = messages;
        this.planner = planner;
        this.attendees = attendees;
    }

// other methods
    public String getEventDateFormatted() {
        SimpleDateFormat df = new SimpleDateFormat("dd,MM,YYYY");
        return df.format(this.eventDate);
    }
//Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public User getPlanner() {
        return planner;
    }

    public List<User> getAttendees() {
        return attendees;
    }

//Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void setPlanner(User planner) {
        this.planner = planner;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }

// other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
