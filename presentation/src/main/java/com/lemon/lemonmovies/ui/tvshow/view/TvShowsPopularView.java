package com.lemon.lemonmovies.ui.tvshow.view;

import com.lemon.lemonmovies.model.result.TvShowResultDataModel;
import com.lemon.lemonmovies.ui.base.BaseView;

import java.util.List;

public interface TvShowsPopularView extends BaseView {

    void showPopularTvShows(final List<TvShowResultDataModel> tvShows);
}

