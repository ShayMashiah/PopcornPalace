package com.att.tdp.popcorn_palace.controller;


import com.att.tdp.popcorn_palace.entity.Movie;
import com.att.tdp.popcorn_palace.service.MovieService;

import jakarta.persistence.PostUpdate;
import lombok.extern.slf4j.Slf4j;

import com.att.tdp.popcorn_palace.DTO.MoviesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController // This means this class is a Controller`
@RequestMapping("/movies") // This means URL's start with /movies (after Application path)
@Slf4j
public class MovieController {
    @Autowired
    private MovieService movieService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping("/")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long id, @RequestBody MoviesDto movieDto) {
        log.info("Searching for movie with title controller: {}", id);
        movieService.updateMovie(id, movieDto);
        return ResponseEntity.ok(null);

    }
    
} 