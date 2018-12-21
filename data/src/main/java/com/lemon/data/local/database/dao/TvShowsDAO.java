package com.lemon.data.local.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Update;

import com.lemon.data.local.entity.TvShowEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Dao interface {@link Dao} of database {@link RoomDatabase} for TvShows table {@link TvShowEntity}
 */
@Dao
public interface TvShowsDAO {

    /**
     * Receiving list of recent tv shows ordered by creation date.
     *
     * @return {@link Flowable} with list of recent tv shows
     */
    @Query("SELECT * FROM TvShows WHERE recent = 1 ORDER BY creation_date DESC")
    Flowable<List<TvShowEntity>> getRecentTvShows();

    /**
     * Receiving list of watchlist tv shows ordered by creation date.
     *
     * @return {@link Flowable} with list of watchlist tv shows
     */
    @Query("SELECT * FROM TvShows WHERE watchlist = 1 ORDER BY creation_date DESC")
    Flowable<List<TvShowEntity>> getWatchlistTvShows();

    /**
     * Receiving list of favorite tv shows ordered by creation date.
     *
     * @return {@link Flowable} with list of favorite tv shows
     */
    @Query("SELECT * FROM TvShows WHERE favorite = 1 ORDER BY creation_date DESC")
    Flowable<List<TvShowEntity>> getFavoriteTvShows();

    /**
     * Receiving tv show details by id
     *
     * @param tvShowId - a tv show id
     * @return {@link Single} with tv show details
     */
    @Query("SELECT * FROM TvShows WHERE id = :tvShowId")
    Single<TvShowEntity> getTvShowById(final int tvShowId);

    /**
     * Deleting all tv shows
     */
    @Query("DELETE FROM TvShows")
    void clearTvShows();

    /**
     * Deleting tv show
     *
     * @param tvShowEntity - a tv show to delete
     */
    @Delete
    void deleteTvShow(final TvShowEntity tvShowEntity);

    /**
     * Adding tv show, replacing on conflicts {@link OnConflictStrategy}
     *
     * @param tvShowEntity - a tv show to add
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTvShow(final TvShowEntity tvShowEntity);

    /**
     * Updating tv show
     *
     * @param tvShowEntity - a tv show to update
     */
    @Update
    void updateTvShow(final TvShowEntity tvShowEntity);
}
