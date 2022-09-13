package com.example.demo;

import com.example.demo.services.Movie;
import com.example.demo.services.MovieRepository;
import com.example.demo.services.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class BackendFinalApplicationTests {

	@Autowired
	private MovieService movieService;
	@MockBean
	private MovieRepository movieRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void deleteMovie() {
		Movie movie = new Movie("8","The holiday", "Drama" , 110 , "Two girls from different countries swap homes for" +
				" the holidays to get away from their relationship issues. However, their lives change unexpectedly when they meet and fall in" +
				" love with two local guys." , 6);
		movieService.deleteMovie(movie);
		verify(movieRepository, times(1)).delete(movie);
	}

	@Test
	public void addMovie() {
		Movie movie = new Movie("8","The holiday", "Drama" , 110 , "Two girls from different countries swap homes for" +
				" the holidays to get away from their relationship issues. However, their lives change unexpectedly when they meet and fall in" +
				" love with two local guys." , 6);
		when(movieRepository.save(movie)).thenReturn(movie);
		assertEquals(movie, movieService.addMovie(movie));
	}
	@Test
	public void getMovies() {
		when(movieRepository.findAll()).thenReturn(Stream
				.of(new Movie("8","The holiday", "Drama" , 110 , "Two girls from different countries swap homes for" +
						" the holidays to get away from their relationship issues. However, their lives change unexpectedly when they meet and fall in" +
						" love with two local guys." , 6), new Movie("9" , "Black Panther" , "Adventure", 122, "T'Challa, heir to the hidden but advanced " +
						"kingdom of Wakanda, must step forward to lead his people into a new future and must confront a challenger." , 8)).collect(Collectors.toList()));
		assertEquals(2, movieService.getMoviesUnsorted().size());
	}

	@Test
	public void getMovieByID() {
		String id = "8";
		when(movieRepository.findByAddress(id))
				.thenReturn(Stream.of(new Movie("8","The holiday", "Drama" , 110 , "Two girls from different countries swap homes for" +
						" the holidays to get away from their relationship issues. However, their lives change unexpectedly when they meet and fall in" +
						" love with two local guys." , 6)).collect(Collectors.toList()));
		assertEquals(1, movieService.getMovieById(id).size());
	}


}
