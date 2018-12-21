package com.lemon.lemonmovies.di.component;

import com.lemon.lemonmovies.di.module.MovieDetailModule;
import com.lemon.lemonmovies.di.module.MoviesModule;
import com.lemon.lemonmovies.di.module.MoviesPopularModule;
import com.lemon.lemonmovies.di.module.MoviesSearchModule;
import com.lemon.lemonmovies.di.scope.MoviesScope;
import com.lemon.lemonmovies.ui.movie.fragment.MovieDetailFragment;
import com.lemon.lemonmovies.ui.movie.fragment.MoviesFragment;
import com.lemon.lemonmovies.ui.movie.fragment.MoviesPopularFragment;
import com.lemon.lemonmovies.ui.movie.fragment.MoviesSearchFragment;

import dagger.Subcomponent;

@MoviesScope
@Subcomponent(modules = {MoviesModule.class, MovieDetailModule.class, MoviesSearchModule.class, MoviesPopularModule.class})
public interface MoviesSubComponent {

    void inject(final MoviesFragment moviesFragment);

    void inject(final MovieDetailFragment movieDetailFragment);

    void inject(final MoviesSearchFragment moviesSearchFragment);

    void inject(final MoviesPopularFragment moviesPopularFragment);
}
