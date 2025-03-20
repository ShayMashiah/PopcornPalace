package com.att.tdp.popcorn_palace.DTO;

public class MoviesDto {
    private Long id;
    private String title;
    private String genre;
    private Integer duration;
    private Double rating;
    private Integer releaseYear;

    public MoviesDto(Long id, String title, String genre, Integer duration, Double rating, Integer releaseYear) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }
    
}