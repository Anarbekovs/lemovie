package com.lemon.lemonmovies.di.module;

import com.lemon.lemonmovies.di.scope.TvShowsScope;
import com.lemon.lemonmovies.ui.tvshow.presenter.TvShowsSearchPresenter;
import com.lemon.domain.repository.TvShowsRepository;
import com.lemon.domain.usecase.tvshow.SearchTvShowsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class TvShowsSearchModule {

    @Provides
    @TvShowsScope
    TvShowsSearchPresenter providesTvShowsSearchPresenter(final SearchTvShowsUseCase searchTvShowsUseCase) {
        return new TvShowsSearchPresenter(searchTvShowsUseCase);
    }

    @Provides
    @TvShowsScope
    SearchTvShowsUseCase providesSearchTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        return new SearchTvShowsUseCase(tvShowsRepository);
    }
}
