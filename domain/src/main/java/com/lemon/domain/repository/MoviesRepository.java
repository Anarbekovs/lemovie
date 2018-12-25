package com.lemon.domain.repository;

import com.lemon.domain.model.detail.MovieDetailModel;
import com.lemon.domain.model.item.MovieItemModel;
import com.lemon.domain.model.result.MovieResultModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * A MoviesRepository domain interface
 */
public interface MoviesRepository {

    /**
     * Getting a list of recent movies
     *
     * @return {@link Observable} of movie items list
     */
    Observable<List<MovieItemModel>> getRecentMovies();

    /**
     * Getting a list of watchlist movies
     *
     * @return {@link Observable} of movie items list
     */
    Observable<List<MovieItemModel>> getWatchlistMovies();

    /**
     * Getting a list of favorite movies
     *
     * @return {@link Observable} of movie items list
     */
    Observable<List<MovieItemModel>> getFavoriteMovies();

    /**
     * Getting a movie details by id
     *
     * @param movieId - a movie id
     * @return {@link Observable} of movie details
     */
    Observable<MovieDetailModel> getMovieDetailsById(final int movieId);

    /**
     * Getting a list of popular movies
     *
     * @param page - a page number
     * @return {@link Observable} of popular movie results list
     */
    Observable<List<MovieResultModel>> getPopularMovies(final int page);

    /**
     * Getting a list of movies by search query
     *
     * @param query - a search query string
     * @param page  - a page number
     * @return {@link Observable} of search results list
     */
    Observable<List<MovieResultModel>> searchMoviesByQuery(final String query, final int page);

    /**
     * Apply rating to movie
     *
     * @param movieId - a movie id
     * @param rating  - a movie new rating
     * @return {@link Disposable}
     */
    Disposable setMovieRating(final int movieId, final double rating);

    /**
     * Add movie to watchlist
     *
     * @param movieId - a movie id
     * @return {@link Disposable}
     */
    Disposable addMovieToWatchlist(final int movieId);

    /**
     * Add movie to favorites
     *
     * @param movieId - a movie id
     * @return {@link Disposable}
     */
    Disposable addMovieToFavorites(final int movieId);

    /**
     * Delete movie from recent
     *
     * @param movieId - a movie id
     * @return {@link Disposable}
     */
    Disposable deleteMovieFromRecent(final int movieId);

    /**
     * Delete movie from watchlist
     *
     * @param movieId - a movie id
     * @return {@link Disposable}
     */
    Disposable deleteMovieFromWatchlist(final int movieId);

    /**
     * Delete movie from favorites
     *
     * @param movieId - a movie id
     * @return {@link Disposable}
     */
    Disposable deleteMovieFromFavorites(final int movieId);
    /**
     * Getting the latest movie details
     *
     * @return {@link Observable} of movie details
     */
    Observable<MovieDetailModel> getLatestMovieDetails();
}
