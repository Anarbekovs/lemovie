package com.lemon.lemonmovies.di.component;

import com.lemon.lemonmovies.CatchMovieGlideModule;
import com.lemon.lemonmovies.di.module.AppModule;
import com.lemon.lemonmovies.di.module.DataModule;
import com.lemon.lemonmovies.di.module.NetworkModule;
import com.lemon.lemonmovies.ui.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(final BaseActivity baseActivity);

    void inject(final CatchMovieGlideModule catchMovieGlideModule);

    MoviesSubComponent getMoviesSubComponent();

    TvShowsSubComponent getTvShowsSubComponent();

    PersonsSubComponent getPersonsSubComponent();
}
