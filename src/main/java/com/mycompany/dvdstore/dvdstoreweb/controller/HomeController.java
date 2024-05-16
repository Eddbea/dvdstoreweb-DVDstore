package com.mycompany.dvdstore.dvdstoreweb.controller;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import com.mycompany.dvdstore.dvdstoreweb.controller.form.MovieForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    private final MovieServiceInterface movieService;

    public HomeController(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    @GetMapping("/dvdstore-home")
    public @ModelAttribute("movies") List<Movie> displayHome(){
        System.out.println("HomeController: displayHome");
        return movieService.getMovieList();
    }

    @GetMapping("add-movie-form")
    public void displayMovieForm(@ModelAttribute MovieForm movieForm){

    }
}