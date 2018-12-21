package com.lemon.lemonmovies.ui.tvshow.view;

import com.lemon.lemonmovies.model.result.TvShowResultDataModel;
import com.lemon.lemonmovies.ui.base.BaseView;

import java.util.List;

public interface TvShowsSearchView extends BaseView {

    void showTvShowsSearchResult(final List<TvShowResultDataModel> tvShows);

    void showEmptyText();

    void hideEmptyText();
}

