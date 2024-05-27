package com.mycompany.dvdstore.dvdstoreweb.api;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("Methode get new displayMovieCard invoquee");
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie add(@RequestBody Movie movie){
        return movieService.registerMovie(movie);

    }

    @GetMapping
    public Iterable<Movie> list(){
        return movieService.getMovieList();
    }
}