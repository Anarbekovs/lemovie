package com.lemon.lemonmovies.ui.movie.view;

import com.lemon.lemonmovies.model.result.MovieResultDataModel;
import com.lemon.lemonmovies.ui.base.BaseView;

import java.util.List;

public interface MoviesSearchView extends BaseView {

    void showMoviesSearchResult(final List<MovieResultDataModel> movies);

    void showEmptyText();

    void hideEmptyText();
}
