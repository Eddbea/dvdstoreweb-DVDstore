package com.mycompany.dvdstore.dvdstoreweb.controller;

import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {

    public MovieController(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    private final MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    @RequestMapping("/{id}")
    public String displayMovieCard(@PathVariable("id")long id, Model model){
        model.addAttribute("movie", movieService.getMovieById(id));
        System.out.println("Methode displayMovieCard invoquee");
        return "movie-details";
    }
}