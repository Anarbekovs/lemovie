package com.lemon.lemonmovies.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lemon.lemonmovies.BuildConfig;
import com.lemon.data.remote.api.ApiMapper;
import com.lemon.data.remote.api.TMDbApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public final class NetworkModule {

    private static final int CONNECTION_TIMEOUT_SEC = 15;

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(CONNECTION_TIMEOUT_SEC, TimeUnit.SECONDS)
                .readTimeout(CONNECTION_TIMEOUT_SEC, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG
                        ? HttpLoggingInterceptor.Level.BASIC
                        : HttpLoggingInterceptor.Level.NONE))
                .build();
    }

    @Provides
    @Singleton
    Gson providesGson() {
        return new GsonBuilder().setLenient().create();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(final Gson gson, final OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(TMDbApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    TMDbApi providesApiService(final Retrofit retrofit) {
        return retrofit.create(TMDbApi.class);
    }

    @Provides
    @Singleton
    ApiMapper providesApiMapper(final TMDbApi api) {
        return new ApiMapper(api);
    }
}
