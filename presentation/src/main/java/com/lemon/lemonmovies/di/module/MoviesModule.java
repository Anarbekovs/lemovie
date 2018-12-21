package com.lemon.lemonmovies.di.module;

import com.lemon.lemonmovies.di.scope.MoviesScope;
import com.lemon.lemonmovies.ui.movie.presenter.MoviesPresenter;
import com.lemon.domain.repository.MoviesRepository;
import com.lemon.domain.usecase.movie.AddMovieUseCase;
import com.lemon.domain.usecase.movie.DeleteMovieUseCase;
import com.lemon.domain.usecase.movie.GetMoviesUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class MoviesModule {

    @Provides
    @MoviesScope
    MoviesPresenter providesMoviesPresenter(final GetMoviesUseCase getMoviesUseCase,
                                            final AddMovieUseCase addMovieUseCase,
                                            final DeleteMovieUseCase deleteMovieUseCase) {
        return new MoviesPresenter(getMoviesUseCase, addMovieUseCase, deleteMovieUseCase);
    }


    @Provides
    @MoviesScope
    GetMoviesUseCase providesGetMoviesUseCase(final MoviesRepository moviesRepository) {
        return new GetMoviesUseCase(moviesRepository);
    }

    @Provides
    @MoviesScope
    AddMovieUseCase providesAddMovieUseCase(final MoviesRepository moviesRepository) {
        return new AddMovieUseCase(moviesRepository);
    }

    @Provides
    @MoviesScope
    DeleteMovieUseCase providesDeleteMovieUseCase(final MoviesRepository moviesRepository) {
        return new DeleteMovieUseCase(moviesRepository);
    }
}
