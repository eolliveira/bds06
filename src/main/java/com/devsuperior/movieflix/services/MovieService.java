package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieAllDetailsDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MovieRepository movieRepositoryrepository;

    @Transactional
    public Page<MovieDTO> SearchMoviesByCategory(Long genreId, Pageable pageable) {
        Genre genre = (genreId == 0) ? null : genreRepository.getOne(genreId);
        Page<MovieDTO> list = movieRepositoryrepository.SearchMoviesByCategory(genre, pageable);
        return list;
    }

    @Transactional
    public MovieAllDetailsDTO findById(Long id){
        Optional<Movie> opt = movieRepositoryrepository.findById(id);
        Movie movie = opt.orElseThrow(() -> new ResourceNotFoundException("Movie id: " + id + " not found"));
        return new MovieAllDetailsDTO(movie);
    }

}
