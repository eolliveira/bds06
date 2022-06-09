package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReviewDTO implements Serializable {
    private Long id;
    @NotBlank
    private String text;
    private Long movieId;
    private UserDTO user;

    public ReviewDTO(Review entity) {
        this.id = entity.getId();
        this.text = entity.getText();
        this.movieId = entity.getMovie().getId();
        this.user = new UserDTO(entity.getUser());
    }

}
