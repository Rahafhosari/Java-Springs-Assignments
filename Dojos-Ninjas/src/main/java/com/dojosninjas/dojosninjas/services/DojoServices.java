package com.dojosninjas.dojosninjas.services;

import com.dojosninjas.dojosninjas.models.Dojo;
import com.dojosninjas.dojosninjas.repositories.DojoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoServices {
    private final DojoRepository dojoRepository;

    public DojoServices(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    // returns all the DOJOS
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }

    //find by id
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if (optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    // creates a Dojo
    public Dojo createDojo(Dojo x) {
        return dojoRepository.save(x);
    }
    //Delete
    public void deleteDojo(Long id) {
        dojoRepository.deleteById(id);
    }

}
