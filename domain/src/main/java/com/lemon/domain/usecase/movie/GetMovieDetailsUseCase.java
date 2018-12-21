package com.lemon.domain.usecase.movie;

import com.lemon.domain.model.detail.MovieDetailModel;
import com.lemon.domain.repository.MoviesRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * A UseCase class for getting movie details
 */
public final class GetMovieDetailsUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public GetMovieDetailsUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<MovieDetailModel> execute(final int movieId) {
        return mMoviesRepository.getMovieDetailsById(movieId);
    }
}
