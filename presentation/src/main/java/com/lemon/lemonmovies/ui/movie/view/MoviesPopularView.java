package com.lemon.lemonmovies.ui.movie.view;

import com.lemon.lemonmovies.model.result.MovieResultDataModel;
import com.lemon.lemonmovies.ui.base.BaseView;

import java.util.List;

public interface MoviesPopularView extends BaseView {

    void showPopularMovies(final List<MovieResultDataModel> movies);
}
