package com.dojosninjas.dojosninjas.repositories;

import com.dojosninjas.dojosninjas.models.Dojo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
}

