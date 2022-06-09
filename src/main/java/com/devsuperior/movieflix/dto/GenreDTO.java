package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GenreDTO implements Serializable {
    private Long id;
    private String name;

    public GenreDTO(Genre entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

}
