package com.learning.basics.project.reactor.service;

import com.learning.basics.project.reactor.model.MovieInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static com.learning.basics.project.reactor.util.CommonUtil.delay;

public class MovieInfoService {

    public  Flux<MovieInfo> retrieveMoviesFlux(){
        List<MovieInfo> movieInfoList = Arrays.asList(new MovieInfo(100L, "Batman Begins", 2005, Arrays.asList("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15")),
                new MovieInfo(101L,"The Dark Knight", 2008, Arrays.asList("Christian Bale", "HeathLedger"), LocalDate.parse("2008-07-18")),
                new MovieInfo(102L,"Dark Knight Rises", 2008, Arrays.asList("Christian Bale", "Tom Hardy"), LocalDate.parse("2012-07-20")));
        return Flux.fromIterable(movieInfoList);
    }

    public  Mono<MovieInfo> retrieveMovieInfoMonoUsingId(long movieId){
        MovieInfo movie = new MovieInfo(movieId, "Batman Begins", 2005, Arrays.asList("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"));
        return Mono.just(movie);
    }

    public  List<MovieInfo> movieList(){
        delay(1000);
        return Arrays.asList(new MovieInfo(100L, "Batman Begins", 2005, Arrays.asList("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15")),
                new MovieInfo(101L,"The Dark Knight", 2008, Arrays.asList("Christian Bale", "HeathLedger"), LocalDate.parse("2008-07-18")),
                new MovieInfo(102L,"Dark Knight Rises", 2008, Arrays.asList("Christian Bale", "Tom Hardy"), LocalDate.parse("2012-07-20")));
    }

    public  MovieInfo retrieveMovieUsingId(long movieId){
        delay(1000);
        return new MovieInfo(movieId, "Batman Begins", 2005, Arrays.asList("Christian Bale", "Michael Cane"), LocalDate.parse("2005-06-15"));
    }

}