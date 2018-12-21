package com.lemon.lemonmovies;

import android.app.Application;
import android.support.annotation.NonNull;

import com.lemon.lemonmovies.di.component.AppComponent;
import com.lemon.lemonmovies.di.component.DaggerAppComponent;
import com.lemon.lemonmovies.di.module.AppModule;

import timber.log.Timber;

public final class LemonMoviesApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
        configureTimber();
    }

    /**
     * Initialize dagger AppComponent with AppModule
     *
     * @see AppComponent
     * @see AppModule
     */
    private void initAppComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    /**
     * Configure Timber for logging, for release version uses TimberReleaseTree class.
     *
     * @see TimberReleaseTree
     */
    private void configureTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected String createStackElementTag(@NonNull StackTraceElement element) {
                    return super.createStackElementTag(element) + ":" + element.getLineNumber();
                }
            });
        } else {
            Timber.plant(new TimberReleaseTree());
        }
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
