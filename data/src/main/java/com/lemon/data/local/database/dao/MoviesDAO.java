package com.lemon.data.local.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Update;

import com.lemon.data.local.entity.MovieEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Dao interface {@link Dao} of database {@link RoomDatabase} for Movies table {@link MovieEntity}
 */
@Dao
public interface MoviesDAO {

    /**
     * Receiving list of recent movies ordered by creation date.
     *
     * @return {@link Flowable} with list of recent movies
     */
    @Query("SELECT * FROM Movies WHERE recent = 1 ORDER BY creation_date DESC")
    Flowable<List<MovieEntity>> getRecentMovies();

    /**
     * Receiving list of watchlist movies ordered by creation date.
     *
     * @return {@link Flowable} with list of watchlist movies
     */
    @Query("SELECT * FROM Movies WHERE watchlist = 1 ORDER BY creation_date DESC")
    Flowable<List<MovieEntity>> getWatchlistMovies();

    /**
     * Receiving list of favorite movies ordered by creation date.
     *
     * @return {@link Flowable} with list of favorite movies
     */
    @Query("SELECT * FROM Movies WHERE favorite = 1 ORDER BY creation_date DESC")
    Flowable<List<MovieEntity>> getFavoriteMovies();

    /**
     * Receiving movie details by id
     *
     * @param movieId - a movie id
     * @return {@link Single} with movie details
     */
    @Query("SELECT * FROM Movies WHERE id = :movieId")
    Single<MovieEntity> getMovieById(final int movieId);

    /**
     * Deleting all movies
     */
    @Query("DELETE FROM Movies")
    void clearMovies();

    /**
     * Deleting movie
     *
     * @param movieEntity - a movie to delete
     */
    @Delete
    void deleteMovie(final MovieEntity movieEntity);

    /**
     * Adding movie, replacing on conflicts {@link OnConflictStrategy}
     *
     * @param movieEntity - a movie to add
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(final MovieEntity movieEntity);

    /**
     * Updating movie
     *
     * @param movieEntity - a movie to update
     */
    @Update
    void updateMovie(final MovieEntity movieEntity);
}
