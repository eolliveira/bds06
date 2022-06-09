package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private UserService userService;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    //Obter classificações do filme
    public List<ReviewDTO> movieRating(Long id){
        Optional<Movie> opt = movieRepository.findById(id);
        Movie movie = opt.orElseThrow(() -> new ResourceNotFoundException("Resource id: " + id + " not found"));
        List<ReviewDTO> reviews = reviewRepository.movieRating(movie);
        return reviews;
    }

    @Transactional
    public ReviewDTO newReview(ReviewDTO dto){
        Review review = new Review();
        review.setId(dto.getId());
        review.setText(dto.getText());

        Optional<Movie> optMovie = movieRepository.findById(dto.getMovieId());
        Movie movie = optMovie.orElseThrow(() -> new ResourceNotFoundException("Movie id: " + dto.getMovieId() + " not found"));

        User user = userService.authenticated();

        review.setMovie(movie);
        review.setUser(user);

        review = reviewRepository.save(review);

        return new ReviewDTO(review);
    }

}
