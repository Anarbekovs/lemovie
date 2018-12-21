package com.lemon.lemonmovies.di.module;

import com.lemon.lemonmovies.di.scope.TvShowsScope;
import com.lemon.lemonmovies.ui.tvshow.presenter.TvShowDetailPresenter;
import com.lemon.domain.repository.TvShowsRepository;
import com.lemon.domain.usecase.tvshow.AddTvShowUseCase;
import com.lemon.domain.usecase.tvshow.DeleteTvShowUseCase;
import com.lemon.domain.usecase.tvshow.GetTvShowDetailsUseCase;
import com.lemon.domain.usecase.tvshow.SetTvShowRatingUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class TvShowDetailModule {

    @Provides
    @TvShowsScope
    TvShowDetailPresenter providesTvShowDetailPresenter(final GetTvShowDetailsUseCase getTvShowDetailsUseCase,
                                                        final SetTvShowRatingUseCase setTvShowRatingUseCase,
                                                        final AddTvShowUseCase addTvShowUseCase,
                                                        final DeleteTvShowUseCase deleteTvShowUseCase) {
        return new TvShowDetailPresenter(getTvShowDetailsUseCase, setTvShowRatingUseCase,
                addTvShowUseCase, deleteTvShowUseCase);
    }

    @Provides
    @TvShowsScope
    GetTvShowDetailsUseCase providesGetTvShowDetailsUseCase(final TvShowsRepository moviesRepository) {
        return new GetTvShowDetailsUseCase(moviesRepository);
    }

    @Provides
    @TvShowsScope
    SetTvShowRatingUseCase providesSetTvShowRatingUseCase(final TvShowsRepository tvShowsRepository) {
        return new SetTvShowRatingUseCase(tvShowsRepository);
    }
}
