package com.learning.basics.project.reactor.service;

import com.learning.basics.project.reactor.model.Review;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class ReviewService {

    public  List<Review> retrieveReviews(long movieInfoId){

        return Arrays.asList(new Review(1L, movieInfoId, "Awesome Movie", 8.9),
                new Review(2L, movieInfoId, "Excellent Movie", 9.0));
    }

    public Flux<Review> retrieveReviewsFlux(long movieInfoId){

        List<Review> reviewsList = Arrays.asList(new Review(1L,movieInfoId, "Awesome Movie", 8.9),
                new Review(2L, movieInfoId, "Excellent Movie", 9.0));
        return Flux.fromIterable(reviewsList);
    }

}