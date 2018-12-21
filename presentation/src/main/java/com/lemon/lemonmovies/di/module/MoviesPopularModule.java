package com.lemon.lemonmovies.di.module;

import com.lemon.lemonmovies.di.scope.MoviesScope;
import com.lemon.lemonmovies.ui.movie.presenter.MoviesPopularPresenter;
import com.lemon.domain.repository.MoviesRepository;
import com.lemon.domain.usecase.movie.GetPopularMoviesUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class MoviesPopularModule {

    @Provides
    @MoviesScope
    MoviesPopularPresenter providesPopularMoviesPresenter(final GetPopularMoviesUseCase getPopularMoviesUseCase) {
        return new MoviesPopularPresenter(getPopularMoviesUseCase);
    }

    @Provides
    @MoviesScope
    GetPopularMoviesUseCase providesGetPopularMoviesUseCase(final MoviesRepository moviesRepository) {
        return new GetPopularMoviesUseCase(moviesRepository);
    }
}
