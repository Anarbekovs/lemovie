package com.lemon.data.repository;

import com.lemon.data.local.database.dao.MoviesDAO;
import com.lemon.data.mapper.MovieDetailDataMapper;
import com.lemon.data.mapper.MovieEntityMapper;
import com.lemon.data.mapper.MovieItemDataMapper;
import com.lemon.data.mapper.MovieResultDataMapper;
import com.lemon.data.remote.api.ApiMapper;
import com.lemon.domain.model.detail.MovieDetailModel;
import com.lemon.domain.model.item.MovieItemModel;
import com.lemon.domain.model.result.MovieResultModel;
import com.lemon.domain.repository.MoviesRepository;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Implementation of MoviesRepository interface
 *
 * @see MoviesRepository
 */
public final class MoviesRepositoryImpl implements MoviesRepository {

    private final MoviesDAO mMoviesDao;
    private final ApiMapper mApiMapper;

    @Inject
    public MoviesRepositoryImpl(final MoviesDAO moviesDAO, final ApiMapper apiMapper) {
        this.mMoviesDao = moviesDAO;
        this.mApiMapper = apiMapper;
    }

    @Override
    public Observable<List<MovieItemModel>> getRecentMovies() {
        return mMoviesDao.getRecentMovies()
                .map(MovieItemDataMapper::transform)
                .toObservable();
    }

    @Override
    public Observable<List<MovieItemModel>> getWatchlistMovies() {
        return mMoviesDao.getWatchlistMovies()
                .map(MovieItemDataMapper::transform)
                .toObservable();
    }

    @Override
    public Observable<List<MovieItemModel>> getFavoriteMovies() {
        return mMoviesDao.getFavoriteMovies()
                .map(MovieItemDataMapper::transform)
                .toObservable();
    }

    @Override
    public Observable<MovieDetailModel> getMovieDetailsById(final int movieId) {
        return mMoviesDao.getMovieById(movieId).toObservable()
                .observeOn(Schedulers.computation())
                .onErrorResumeNext(throwable -> {
                    return mApiMapper.getMovieDetails(movieId)
                            .map(MovieEntityMapper::transform)
                            .doOnNext(entity -> {
                                entity.setRecent(true);
                                entity.setCreationDate(new Date());
                                mMoviesDao.insertMovie(entity);
                            });
                }).map(MovieDetailDataMapper::transform);
    }

    @Override
    public Observable<List<MovieResultModel>> getPopularMovies(final int page) {
        return mApiMapper.getPopularMovies(page)
                .map(MovieResultDataMapper::transform);
    }

    @Override
    public Observable<List<MovieResultModel>> searchMoviesByQuery(final String query, final int page) {
        return mApiMapper.searchMoviesByQuery(query, page)
                .map(MovieResultDataMapper::transform);
    }

    @Override
    public Disposable setMovieRating(final int movieId, final double rating) {
        return mMoviesDao.getMovieById(movieId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    entity.setRating(rating);
                    mMoviesDao.updateMovie(entity);
                }).subscribe();
    }

    @Override
    public Disposable addMovieToWatchlist(final int movieId) {
        return mMoviesDao.getMovieById(movieId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    entity.setWatchlist(true);
                    mMoviesDao.updateMovie(entity);
                }).subscribe();
    }

    @Override
    public Disposable addMovieToFavorites(final int movieId) {
        return mMoviesDao.getMovieById(movieId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    entity.setFavorite(true);
                    mMoviesDao.updateMovie(entity);
                }).subscribe();
    }

    @Override
    public Disposable deleteMovieFromRecent(final int movieId) {
        return mMoviesDao.getMovieById(movieId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    if (!entity.isWatchlist() && !entity.isFavorite()) {
                        mMoviesDao.deleteMovie(entity);
                    } else {
                        entity.setRecent(false);
                        mMoviesDao.updateMovie(entity);
                    }
                }).subscribe();
    }

    @Override
    public Disposable deleteMovieFromWatchlist(final int movieId) {
        return mMoviesDao.getMovieById(movieId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    if (!entity.isRecent() && !entity.isFavorite()) {
                        mMoviesDao.deleteMovie(entity);
                    } else {
                        entity.setWatchlist(false);
                        mMoviesDao.updateMovie(entity);
                    }
                }).subscribe();
    }

    @Override
    public Disposable deleteMovieFromFavorites(final int movieId) {
        return mMoviesDao.getMovieById(movieId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    if (!entity.isRecent() && !entity.isWatchlist()) {
                        mMoviesDao.deleteMovie(entity);
                    } else {
                        entity.setFavorite(false);
                        mMoviesDao.updateMovie(entity);
                    }
                }).subscribe();
    }
}
