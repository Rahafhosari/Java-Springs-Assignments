package com.dojosninjas.dojosninjas.services;

import com.dojosninjas.dojosninjas.models.Dojo;
import com.dojosninjas.dojosninjas.models.Ninja;
import com.dojosninjas.dojosninjas.repositories.DojoRepository;
import com.dojosninjas.dojosninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoNinjaService {
    private final DojoRepository dojoRepo;
    private final NinjaRepository ninjaRepo;

    public DojoNinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
        this.dojoRepo = dojoRepo;
        this.ninjaRepo = ninjaRepo;
    }

    // returns all the DOJOS
    public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }

    //find by id
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if (optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    // creates a Dojo
    public Dojo createDojo(Dojo x) {
        return dojoRepo.save(x);
    }
    //Delete
    public void deleteDojo(Long id) {
        dojoRepo.deleteById(id);
    }

    // returns all the Ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }

    //find by id
    public Ninja findNinja(Long id) { return ninjaRepo.findById(id).orElse(null); }

    // creates a Ninja
    public Ninja createNinja(Ninja x) { return ninjaRepo.save(x); }

    //Delete
    public void deleteNinja(Long id) {
        ninjaRepo.deleteById(id);
    }

    //Ninjas in a Dojo
    public List<Ninja> NinjasInDojo(Dojo dojo){return ninjaRepo.findNinjaByDojo(dojo);}

}
