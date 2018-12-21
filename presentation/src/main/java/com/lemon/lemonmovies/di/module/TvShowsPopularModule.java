package com.lemon.lemonmovies.di.module;

import com.lemon.lemonmovies.di.scope.TvShowsScope;
import com.lemon.lemonmovies.ui.tvshow.presenter.TvShowsPopularPresenter;
import com.lemon.domain.repository.TvShowsRepository;
import com.lemon.domain.usecase.tvshow.GetPopularTvShowsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class TvShowsPopularModule {

    @Provides
    @TvShowsScope
    TvShowsPopularPresenter providesPopularTvShowsPresenter(final GetPopularTvShowsUseCase getPopularTvShowsUseCase) {
        return new TvShowsPopularPresenter(getPopularTvShowsUseCase);
    }

    @Provides
    @TvShowsScope
    GetPopularTvShowsUseCase providesGetPopularTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        return new GetPopularTvShowsUseCase(tvShowsRepository);
    }
}
