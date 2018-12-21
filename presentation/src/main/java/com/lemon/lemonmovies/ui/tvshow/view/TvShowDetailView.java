package com.lemon.lemonmovies.ui.tvshow.view;

import com.lemon.lemonmovies.model.detail.TvShowDetailDataModel;
import com.lemon.lemonmovies.ui.base.BaseView;

public interface TvShowDetailView extends BaseView {

    void setTvShowDetails(final TvShowDetailDataModel tvShow);

    void setWatchlistStatus(final boolean isWatchlist);

    void setFavoriteStatus(final boolean isFavorite);
}