package com.javaspring.events.repositories;

import com.javaspring.events.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
