package com.example.demo.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String>, PagingAndSortingRepository<Movie, String> {
    List<Movie> findByAddress(String id);
}
