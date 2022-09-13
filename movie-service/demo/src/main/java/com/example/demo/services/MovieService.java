package com.example.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Page<Movie> getMovies(MoviePages moviePages){
        Sort sort = Sort.by(moviePages.getSortDirection(), moviePages.getSortBy());
        Pageable pageable = PageRequest.of(moviePages.getPageNumber(),
                moviePages.getPageSize(), sort);
        return movieRepository.findAll(pageable);
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public void deleteMovie(Movie movie){
     movieRepository.delete(movie);
    }

    public List<Movie> getMoviesUnsorted() {
        List<Movie> movies = movieRepository.findAll();
        System.out.println("Getting data from DB : " + movies);
        return movies;
    }
    public List<Movie> getMovieById(String id) {
        return movieRepository.findByAddress(id);
    }

}


