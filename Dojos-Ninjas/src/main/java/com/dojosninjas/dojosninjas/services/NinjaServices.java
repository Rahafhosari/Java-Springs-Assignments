package com.dojosninjas.dojosninjas.services;

import com.dojosninjas.dojosninjas.models.Ninja;
import com.dojosninjas.dojosninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaServices {
    private final NinjaRepository ninjaRepository;

    public NinjaServices(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // returns all the Ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }

    //find by id
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if (optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    // creates a Ninja
    public Ninja createNinja(Ninja x) {
        return ninjaRepository.save(x);
    }
    //Delete
    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
}
