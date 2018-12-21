package com.lemon.lemonmovies.ui.movie.view;

import com.lemon.lemonmovies.model.item.MovieItemDataModel;
import com.lemon.lemonmovies.ui.base.BaseView;

import java.util.List;

public interface MoviesView extends BaseView {

    void setMovies(final List<MovieItemDataModel> movies);

    void clearMovies();

    void showEmptyText();

    void hideEmptyText();
}
