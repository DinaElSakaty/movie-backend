package com.example.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieRepository movieRepository;
    private final MovieService movieService;

    public MovieController(MovieRepository movieRepository,MovieService movieService) {
        this.movieRepository = movieRepository;
        this.movieService=movieService;
    }
//    @GetMapping("/movies")
//    public List<Movie> getMovies() {
//
//        return movieRepository.findAll() ;
//    }
    @GetMapping("/movies")
    public ResponseEntity<Page<Movie>> getMovies(MoviePages page){
        return new ResponseEntity<> (movieService.getMovies(page), HttpStatus.OK);
    }
    @GetMapping("/movies/{id}")
    public Movie movie(@PathVariable String id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }
    @DeleteMapping("/movies/{id}")
    public void deleteRestaurant(@PathVariable String id) {
        movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
        movieRepository.deleteById(id);
    }

    @PostMapping("/movies")
    public void saveRestaurant(@RequestBody Movie movie) {
        movieRepository.save(movie);
    }


}
