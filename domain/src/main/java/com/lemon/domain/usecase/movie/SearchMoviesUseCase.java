package com.lemon.domain.usecase.movie;

import com.lemon.domain.model.result.MovieResultModel;
import com.lemon.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * A UseCase class for search movies by query string
 */
public final class SearchMoviesUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public SearchMoviesUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<List<MovieResultModel>> execute(final String query, final int page) {
        return mMoviesRepository.searchMoviesByQuery(query, page);
    }
}
