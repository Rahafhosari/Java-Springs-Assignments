package com.lookify.lookify.Repositories;

import com.lookify.lookify.Models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long> {

    List<Song> findAll();

    List<Song> findByArtist(String artist);

    List<Song> findTop10ByOrderByRatingDesc();
}
