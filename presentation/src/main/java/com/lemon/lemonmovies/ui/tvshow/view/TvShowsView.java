package com.lemon.lemonmovies.ui.tvshow.view;

import com.lemon.lemonmovies.model.item.TvShowItemDataModel;
import com.lemon.lemonmovies.ui.base.BaseView;

import java.util.List;

public interface TvShowsView extends BaseView {

    void setTvShows(final List<TvShowItemDataModel> tvShows);

    void clearTvShows();

    void showEmptyText();

    void hideEmptyText();
}
