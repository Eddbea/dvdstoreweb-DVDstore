package com.mycompany.dvdstore.dvdstoreweb.controller;

import com.mycompany.dvdstore.core.entity.Actor;
import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import com.mycompany.dvdstore.dvdstoreweb.form.MovieForm;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    /*@GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id")long id, Model model){
        model.addAttribute("movie", movieService.getMovieById(id));
        System.out.println("Methode displayMovieCard invoquee");
        return "movie-details";
    }*/

    @PostMapping("add")
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult results){
        if(results.hasErrors()){
            return "add-movie-form";
        }
        else {
            Movie movie = new Movie();
            Actor mainActor = new Actor();
            mainActor.setFirstName(movieForm.getFirstName());
            mainActor.setLastName(movieForm.getLastName());
            movie.setMainActor(mainActor);
            movie.setTitle(movieForm.getTitle());
            movie.setGenre(movieForm.getGenre());
            movie.setDescription(movieForm.getDescription());
            movieService.registerMovie(movie);
            return"movie-added";
        }
    }
}