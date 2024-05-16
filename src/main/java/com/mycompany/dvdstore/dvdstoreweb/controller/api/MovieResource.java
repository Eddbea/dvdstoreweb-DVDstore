package com.mycompany.dvdstore.dvdstoreweb.controller.api;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import com.mycompany.dvdstore.dvdstoreweb.controller.form.MovieForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieResource {

    public MovieResource(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    private final MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    @GetMapping("{id}")
    public Movie get(@PathVariable("id")long id){
        System.out.println("Methode getnew displayMovieCard invoquee");
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie add(@RequestBody MovieForm movieForm){
            Movie movie = new Movie();
            movie.setTitle(movieForm.getTitle());
            movie.setGenre(movieForm.getGenre());
            movie.setSummary(movieForm.getSummary());
            movieService.registerMovie(movie);
        return movie;
    }

    @GetMapping
    public List<Movie> list(){
        System.out.println("list : displayHome");
        return movieService.getMovieList();
    }
}