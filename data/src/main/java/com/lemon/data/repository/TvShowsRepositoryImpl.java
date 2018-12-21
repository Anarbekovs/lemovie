package com.lemon.data.repository;

import com.lemon.data.local.database.dao.TvShowsDAO;
import com.lemon.data.mapper.TvShowDetailDataMapper;
import com.lemon.data.mapper.TvShowEntityMapper;
import com.lemon.data.mapper.TvShowItemDataMapper;
import com.lemon.data.mapper.TvShowResultDataMapper;
import com.lemon.data.remote.api.ApiMapper;
import com.lemon.domain.model.detail.TvShowDetailModel;
import com.lemon.domain.model.item.TvShowItemModel;
import com.lemon.domain.model.result.TvShowResultModel;
import com.lemon.domain.repository.TvShowsRepository;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Implementation of TvShowsRepository interface
 *
 * @see TvShowsRepository
 */
public final class TvShowsRepositoryImpl implements TvShowsRepository {

    private final TvShowsDAO mTvShowsDao;
    private final ApiMapper mApiMapper;

    @Inject
    public TvShowsRepositoryImpl(final TvShowsDAO tvShowsDao, final ApiMapper apiMapper) {
        this.mTvShowsDao = tvShowsDao;
        this.mApiMapper = apiMapper;
    }

    @Override
    public Observable<List<TvShowItemModel>> getRecentTvShows() {
        return mTvShowsDao.getRecentTvShows()
                .map(TvShowItemDataMapper::transform)
                .toObservable();
    }

    @Override
    public Observable<List<TvShowItemModel>> getWatchlistTvShows() {
        return mTvShowsDao.getWatchlistTvShows()
                .map(TvShowItemDataMapper::transform)
                .toObservable();
    }

    @Override
    public Observable<List<TvShowItemModel>> getFavoriteTvShows() {
        return mTvShowsDao.getFavoriteTvShows()
                .map(TvShowItemDataMapper::transform)
                .toObservable();
    }

    @Override
    public Observable<TvShowDetailModel> getTvShowDetailsById(final int tvShowId) {
        return mTvShowsDao.getTvShowById(tvShowId).toObservable()
                .observeOn(Schedulers.computation())
                .onErrorResumeNext(throwable -> {
                    return mApiMapper.getTvShowDetails(tvShowId)
                            .map(TvShowEntityMapper::transform)
                            .doOnNext(entity -> {
                                entity.setRecent(true);
                                entity.setCreationDate(new Date());
                                mTvShowsDao.insertTvShow(entity);
                            });
                }).map(TvShowDetailDataMapper::transform);
    }

    @Override
    public Observable<List<TvShowResultModel>> getPopularTvShows(final int page) {
        return mApiMapper.getPopularTvShows(page)
                .map(TvShowResultDataMapper::transform);
    }

    @Override
    public Observable<List<TvShowResultModel>> searchTvShowsByQuery(final String query, final int page) {
        return mApiMapper.searchTvShowsByQuery(query, page)
                .map(TvShowResultDataMapper::transform);
    }

    @Override
    public Disposable setTvShowRating(final int tvShowId, final double rating) {
        return mTvShowsDao.getTvShowById(tvShowId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    entity.setRating(rating);
                    mTvShowsDao.updateTvShow(entity);
                }).subscribe();
    }

    @Override
    public Disposable addTvShowToWatchlist(final int tvShowId) {
        return mTvShowsDao.getTvShowById(tvShowId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    entity.setWatchlist(true);
                    mTvShowsDao.updateTvShow(entity);
                }).subscribe();
    }

    @Override
    public Disposable addTvShowToFavorites(final int tvShowId) {
        return mTvShowsDao.getTvShowById(tvShowId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    entity.setFavorite(true);
                    mTvShowsDao.updateTvShow(entity);
                }).subscribe();
    }

    @Override
    public Disposable deleteTvShowFromRecent(final int tvShowId) {
        return mTvShowsDao.getTvShowById(tvShowId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    if (!entity.isWatchlist() && !entity.isFavorite()) {
                        mTvShowsDao.deleteTvShow(entity);
                    } else {
                        entity.setRecent(false);
                        mTvShowsDao.updateTvShow(entity);
                    }
                }).subscribe();
    }

    @Override
    public Disposable deleteTvShowFromWatchlist(final int tvShowId) {
        return mTvShowsDao.getTvShowById(tvShowId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    if (!entity.isRecent() && !entity.isFavorite()) {
                        mTvShowsDao.deleteTvShow(entity);
                    } else {
                        entity.setWatchlist(false);
                        mTvShowsDao.updateTvShow(entity);
                    }
                }).subscribe();
    }

    @Override
    public Disposable deleteTvShowFromFavorites(final int tvShowId) {
        return mTvShowsDao.getTvShowById(tvShowId).toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(entity -> {
                    if (!entity.isRecent() && !entity.isWatchlist()) {
                        mTvShowsDao.deleteTvShow(entity);
                    } else {
                        entity.setFavorite(false);
                        mTvShowsDao.updateTvShow(entity);
                    }
                }).subscribe();
    }
}
