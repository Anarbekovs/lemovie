package com.lemon.lemonmovies.di.component;

import com.lemon.lemonmovies.di.module.TvShowDetailModule;
import com.lemon.lemonmovies.di.module.TvShowsModule;
import com.lemon.lemonmovies.di.module.TvShowsPopularModule;
import com.lemon.lemonmovies.di.module.TvShowsSearchModule;
import com.lemon.lemonmovies.di.scope.TvShowsScope;
import com.lemon.lemonmovies.ui.tvshow.fragment.TvShowDetailFragment;
import com.lemon.lemonmovies.ui.tvshow.fragment.TvShowsFragment;
import com.lemon.lemonmovies.ui.tvshow.fragment.TvShowsPopularFragment;
import com.lemon.lemonmovies.ui.tvshow.fragment.TvShowsSearchFragment;

import dagger.Subcomponent;

@TvShowsScope
@Subcomponent(modules = {TvShowsModule.class, TvShowDetailModule.class, TvShowsSearchModule.class, TvShowsPopularModule.class})
public interface TvShowsSubComponent {

    void inject(final TvShowsFragment tvShowsFragment);

    void inject(final TvShowDetailFragment tvShowDetailFragment);

    void inject(final TvShowsSearchFragment tvShowsSearchFragment);

    void inject(final TvShowsPopularFragment tvShowsPopularFragment);
}
