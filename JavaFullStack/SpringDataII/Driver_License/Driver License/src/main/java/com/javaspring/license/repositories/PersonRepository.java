package com.javaspring.license.repositories;

import com.javaspring.license.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
}
