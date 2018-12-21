package com.lemon.lemonmovies.di.module;

import com.lemon.lemonmovies.di.scope.MoviesScope;
import com.lemon.lemonmovies.ui.movie.presenter.MoviesSearchPresenter;
import com.lemon.domain.repository.MoviesRepository;
import com.lemon.domain.usecase.movie.SearchMoviesUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class MoviesSearchModule {

    @Provides
    @MoviesScope
    MoviesSearchPresenter providesMoviesSearchPresenter(final SearchMoviesUseCase searchMoviesUseCase) {
        return new MoviesSearchPresenter(searchMoviesUseCase);
    }

    @Provides
    @MoviesScope
    SearchMoviesUseCase providesSearchMoviesUseCase(final MoviesRepository moviesRepository) {
        return new SearchMoviesUseCase(moviesRepository);
    }
}
