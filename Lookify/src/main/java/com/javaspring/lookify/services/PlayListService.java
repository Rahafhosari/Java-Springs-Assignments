package com.javaspring.lookify.services;

import com.javaspring.lookify.models.PlayList;
import com.javaspring.lookify.repositories.PlayListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayListService {
    private final PlayListRepository playListRepository;

    public PlayListService(PlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
    }

    // returns all the songs
    public List<PlayList> allSongs() {
        return playListRepository.findAll();
    }

    // add a song
    public PlayList addSong(PlayList x) {
        return playListRepository.save(x);
    }

    // retrieves a song
    public PlayList findSong(Long id) {
        Optional<PlayList> optionalPlayList = playListRepository.findById(id);
        if (optionalPlayList.isPresent()) {
            return optionalPlayList.get();
        } else {
            return null;
        }
    }

    //Delete
    public void deleteSong(Long id) {
        playListRepository.deleteById(id);
    }
}

//    // update a song
//    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
//        Book updateBook = findBook(id); //saving the book we got by id in a variable
//        updateBook.setTitle(title);
//        updateBook.setDescription(desc);
//        updateBook.setLanguage(lang);
//        updateBook.setNumberOfPages(numOfPages);
//        return bookRepository.save(updateBook);
//    }
