package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MovieAllDetailsDTO extends MovieDTO{
    private String synopsis;
    private GenreDTO genre;
    public MovieAllDetailsDTO(Movie entity) {
        super(entity);
        this.synopsis = entity.getSynopsis();
        this.genre = new GenreDTO(entity.getGenre());
    }
}
