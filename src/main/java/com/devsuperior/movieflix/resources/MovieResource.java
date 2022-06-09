package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.dto.MovieAllDetailsDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;
import com.devsuperior.movieflix.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> SearchMoviesByCategory(
            @RequestParam(value = "genreId", defaultValue = "0") Long genreId,
            Pageable pageable) {

        Page<MovieDTO> page = service.SearchMoviesByCategory(genreId, pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity<List<ReviewDTO>> movieRating(@PathVariable Long id) {
        List<ReviewDTO> list = reviewService.movieRating(id);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieAllDetailsDTO> findById(@PathVariable Long id) {
        MovieAllDetailsDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

}
