package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT obj FROM Movie obj " +
            "WHERE :genre IS NULL OR obj.genre IN :genre " +
            "ORDER BY obj.title ASC")
    Page<MovieDTO> SearchMoviesByCategory(Genre genre, Pageable pageable);
}
