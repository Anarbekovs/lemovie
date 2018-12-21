package com.lemon.domain.usecase.movie;

import com.lemon.domain.model.result.MovieResultModel;
import com.lemon.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * A UseCase class for getting popular movies
 */
public final class GetPopularMoviesUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public GetPopularMoviesUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<List<MovieResultModel>> execute(final int page) {
        return mMoviesRepository.getPopularMovies(page);
    }
}
