package com.javaspring.license.services;

import com.javaspring.license.models.Person;
import com.javaspring.license.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonsService {
    private final PersonRepository personRepository;

    public PersonsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // returns all the persons
    public List<Person> allPersons() {
        return personRepository.findAll();
    }

    //find by id
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }

    // creates a person
    public Person createPerson(Person x) {
        return personRepository.save(x);
    }
}
