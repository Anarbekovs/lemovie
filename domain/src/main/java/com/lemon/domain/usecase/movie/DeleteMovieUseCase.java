package com.lemon.domain.usecase.movie;

import com.lemon.domain.repository.MoviesRepository;
import com.lemon.domain.types.MovieType;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * A UseCase class for deleting movie from collection
 */
public final class DeleteMovieUseCase {

    private final MoviesRepository mMoviesRepository;

    @Inject
    public DeleteMovieUseCase(final MoviesRepository moviesRepository) {
        this.mMoviesRepository = moviesRepository;
    }

    public Disposable execute(final int movieId, final MovieType type) {
        switch (type) {
            case RECENT:
                return mMoviesRepository.deleteMovieFromRecent(movieId);
            case WATCHLIST:
                return mMoviesRepository.deleteMovieFromWatchlist(movieId);
            case FAVORITE:
                return mMoviesRepository.deleteMovieFromFavorites(movieId);
            default:
                return null;
        }
    }
}
