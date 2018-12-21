package com.lemon.domain.repository;

import com.lemon.domain.model.detail.TvShowDetailModel;
import com.lemon.domain.model.item.TvShowItemModel;
import com.lemon.domain.model.result.TvShowResultModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * A TvShowsRepository domain interface
 */
public interface TvShowsRepository {

    /**
     * Getting a list of recent tv shows
     *
     * @return {@link Observable} of tv shows items list
     */
    Observable<List<TvShowItemModel>> getRecentTvShows();

    /**
     * Getting a list of watchlist tv shows
     *
     * @return {@link Observable} of tv shows items list
     */
    Observable<List<TvShowItemModel>> getWatchlistTvShows();

    /**
     * Getting a list of favorite tv shows
     * @return {@link Observable} of tv shows items list
     */
    Observable<List<TvShowItemModel>> getFavoriteTvShows();

    /**
     * Getting a tv show details by id
     * @param tvShowId - a tv show id
     * @return {@link Observable} of tv show details
     */
    Observable<TvShowDetailModel> getTvShowDetailsById(final int tvShowId);

    /**
     * Getting a list of popular tv shows
     * @param page - a page number
     * @return {@link Observable} of popular tv show results list
     */
    Observable<List<TvShowResultModel>> getPopularTvShows(final int page);

    /**
     * Getting a list of tv shows by search query
     * @param query - a search query string
     * @param page - a page number
     * @return {@link Observable} of tv show search results list
     */
    Observable<List<TvShowResultModel>> searchTvShowsByQuery(final String query, final int page);

    /**
     * Apply rating to tv show
     * @param tvShowId - a tv show id
     * @param rating - a tv show new rating
     * @return {@link Disposable}
     */
    Disposable setTvShowRating(final int tvShowId, final double rating);

    /**
     * Add tv show to watchlist
     * @param tvShowId - a tv show id
     * @return {@link Disposable}
     */
    Disposable addTvShowToWatchlist(final int tvShowId);

    /**
     * Add tv show to favorites
     * @param tvShowId - a tv show id
     * @return {@link Disposable}
     */
    Disposable addTvShowToFavorites(final int tvShowId);

    /**
     * Delete tv show from recent
     *
     * @param tvShowId - a tv show id
     * @return {@link Disposable}
     */
    Disposable deleteTvShowFromRecent(final int tvShowId);

    /**
     * Delete tv show from watchlist
     *
     * @param tvShowId - a tv show id
     * @return {@link Disposable}
     */
    Disposable deleteTvShowFromWatchlist(final int tvShowId);

    /**
     * Delete tv show from favorites
     *
     * @param tvShowId - a tv show id
     * @return {@link Disposable}
     */
    Disposable deleteTvShowFromFavorites(final int tvShowId);
}
