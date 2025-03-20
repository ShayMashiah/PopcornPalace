package com.att.tdp.popcorn_palace.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.att.tdp.popcorn_palace.repository.MovieRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import com.att.tdp.popcorn_palace.DTO.MoviesDto;
import com.att.tdp.popcorn_palace.entity.Movie;

@Service
@Slf4j
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }


public void updateMovie(Long id, MoviesDto movieDto) {
    log.info("Searching for movie with title: {}", id);
    Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
    
    if(movieDto.getTitle() != null) {
        movie.setTitle(movieDto.getTitle());
    }
    if(movieDto.getGenre() != null) {
        movie.setGenre(movieDto.getGenre());
    }
    if(movieDto.getDuration() != null) {
        movie.setDuration(movieDto.getDuration());
    }
    if(movieDto.getRating() != null) {
        movie.setRating(movieDto.getRating());
    }
    if(movieDto.getReleaseYear() != null) {
        movie.setReleaseYear(movieDto.getReleaseYear());
    }
    movieRepository.save(movie);
};
    
}

