package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.User;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDTO {
    private Long id;
    private String name;
    private String email;

    public UserDTO(User entity) {
       this.id = entity.getId();
       this.name = entity.getName();
       this.email = entity.getEmail();
    }
}
