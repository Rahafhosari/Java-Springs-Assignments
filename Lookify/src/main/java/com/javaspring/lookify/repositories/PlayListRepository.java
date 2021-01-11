package com.javaspring.lookify.repositories;


import com.javaspring.lookify.models.PlayList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayListRepository extends CrudRepository<PlayList, Long> {
    List<PlayList> findAll();
}
