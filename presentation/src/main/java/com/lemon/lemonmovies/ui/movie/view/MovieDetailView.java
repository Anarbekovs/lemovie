package com.lemon.lemonmovies.ui.movie.view;

import com.lemon.lemonmovies.model.detail.MovieDetailDataModel;
import com.lemon.lemonmovies.ui.base.BaseView;

public interface MovieDetailView extends BaseView {

    void setMovieDetails(final MovieDetailDataModel movie);

    void setWatchlistStatus(final boolean isWatchlist);

    void setFavoriteStatus(final boolean isFavorite);

}
