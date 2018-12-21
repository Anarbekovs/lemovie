package com.lemon.domain.usecase.movie;

import com.lemon.domain.model.item.MovieItemModel;
import com.lemon.domain.repository.MoviesRepository;
import com.lemon.domain.types.MovieType;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * A UseCase class for getting movie collections by movie type
 */
public final class GetMoviesUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public GetMoviesUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Observable<List<MovieItemModel>> execute(final MovieType type) {
        switch (type) {
            case RECENT:
                return mMoviesRepository.getRecentMovies();
            case WATCHLIST:
                return mMoviesRepository.getWatchlistMovies();
            case FAVORITE:
                return mMoviesRepository.getFavoriteMovies();
            default:
                return Observable.empty();
        }
    }
}
