package com.mycompany.dvdstore.dvdstoreweb.controller;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.DefaultMovieService;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id")long id, Model model){
        model.addAttribute("movie", movieService.getMovieById(id));
        System.out.println("Methode displayMovieCard invoquee");
        return "movie-details";
    }

    @PostMapping
    public String addMovie(@ModelAttribute Movie movie){
       movieService.registerMovie(movie);
        return"movie-added";
    }
}