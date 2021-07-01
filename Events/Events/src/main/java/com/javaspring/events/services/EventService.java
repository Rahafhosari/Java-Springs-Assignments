package com.javaspring.events.services;

import com.javaspring.events.models.Event;
import com.javaspring.events.models.Message;
import com.javaspring.events.models.User;
import com.javaspring.events.repositories.EventRepository;
import com.javaspring.events.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eRepo;
    @Autowired
    private MessageRepository mRepo;

    public List<Event> allEventsWithState(String state) {
        return this.eRepo.findByState(state);
    }

    public List<Event> allEventsNotState(String state) {
        return this.eRepo.findByStateIsNot(state);
    }
    public Event findById(Long id) {
        return this.eRepo.findById(id).orElse(null);
    }
    public Event create(Event event) {
        return this.eRepo.save(event);
    }
    public Event update(Event event) {
        return this.eRepo.save(event);
    }
    public void comment(User user, Event event, String comment) {
        this.mRepo.save(new Message(user, event, comment));
    }

    public void delete(Event event) {
        List<Message> messages=event.getMessages();
        for(Message message:messages){
            mRepo.deleteById(message.getId());
        }
        this.eRepo.delete(event);
    }

    public void manageAttendees(Event event, User user, boolean isJoining) {
        if(isJoining) {
            event.getAttendees().add(user);
        } else {
            event.getAttendees().remove(user);
        }
        this.eRepo.save(event);
    }
}
//    public void delete(Long id) {
//
//        this.eRepo.deleteById(id);
//    }
