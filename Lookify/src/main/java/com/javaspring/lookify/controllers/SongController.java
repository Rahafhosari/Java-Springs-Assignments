package com.javaspring.lookify.controllers;

import com.javaspring.lookify.services.PlayListService;
import org.springframework.stereotype.Controller;

@Controller
public class SongController {
    private final PlayListService playListService;
    public SongController(PlayListService playListService) {
        this.playListService = playListService;
    }


}
