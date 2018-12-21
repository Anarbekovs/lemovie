package com.lemon.lemonmovies.di.module;

import com.lemon.lemonmovies.di.scope.TvShowsScope;
import com.lemon.lemonmovies.ui.tvshow.presenter.TvShowsPresenter;
import com.lemon.domain.repository.TvShowsRepository;
import com.lemon.domain.usecase.tvshow.AddTvShowUseCase;
import com.lemon.domain.usecase.tvshow.DeleteTvShowUseCase;
import com.lemon.domain.usecase.tvshow.GetTvShowsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class TvShowsModule {

    @Provides
    @TvShowsScope
    TvShowsPresenter providesTvShowsPresenter(final GetTvShowsUseCase getTvShowsUseCase,
                                              final AddTvShowUseCase addTvShowUseCase,
                                              final DeleteTvShowUseCase deleteTvShowUseCase) {
        return new TvShowsPresenter(getTvShowsUseCase, addTvShowUseCase, deleteTvShowUseCase);
    }

    @Provides
    @TvShowsScope
    GetTvShowsUseCase providesGetTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        return new GetTvShowsUseCase(tvShowsRepository);
    }

    @Provides
    @TvShowsScope
    AddTvShowUseCase providesAddTvShowUseCase(final TvShowsRepository tvShowsRepository) {
        return new AddTvShowUseCase(tvShowsRepository);
    }

    @Provides
    @TvShowsScope
    DeleteTvShowUseCase providesDeleteTvShowUseCase(final TvShowsRepository tvShowsRepository) {
        return new DeleteTvShowUseCase(tvShowsRepository);
    }
}
