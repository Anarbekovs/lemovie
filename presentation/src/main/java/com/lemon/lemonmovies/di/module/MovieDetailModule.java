package com.lemon.lemonmovies.di.module;

import com.lemon.lemonmovies.di.scope.MoviesScope;
import com.lemon.lemonmovies.ui.movie.presenter.MovieDetailPresenter;
import com.lemon.domain.repository.MoviesRepository;
import com.lemon.domain.usecase.movie.AddMovieUseCase;
import com.lemon.domain.usecase.movie.DeleteMovieUseCase;
import com.lemon.domain.usecase.movie.GetMovieDetailsUseCase;
import com.lemon.domain.usecase.movie.SetMovieRatingUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class MovieDetailModule {

    @Provides
    @MoviesScope
    MovieDetailPresenter providesMovieDetailPresenter(final GetMovieDetailsUseCase getMovieDetailsUseCase,
                                                      final SetMovieRatingUseCase setMovieRatingUseCase,
                                                      final AddMovieUseCase addMovieUseCase,
                                                      final DeleteMovieUseCase deleteMovieUseCase) {
        return new MovieDetailPresenter(getMovieDetailsUseCase, setMovieRatingUseCase,
                addMovieUseCase, deleteMovieUseCase);
    }

    @Provides
    @MoviesScope
    GetMovieDetailsUseCase providesGetMovieDetailsUseCase(final MoviesRepository moviesRepository) {
        return new GetMovieDetailsUseCase(moviesRepository);
    }

    @Provides
    @MoviesScope
    SetMovieRatingUseCase providesSetMovieRatingUseCase(final MoviesRepository moviesRepository) {
        return new SetMovieRatingUseCase(moviesRepository);
    }
}
