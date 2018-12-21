package com.lemon.data.local.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Update;

import com.lemon.data.local.entity.PersonEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Dao interface {@link Dao} of database {@link RoomDatabase} for Persons table {@link PersonEntity}
 */
@Dao
public interface PersonsDAO {

    /**
     * Receiving list of favorite persons ordered by creation date.
     *
     * @return {@link Flowable} with list of favorite persons
     */
    @Query("SELECT * FROM Persons WHERE favorite = 1 ORDER BY creation_date DESC")
    Flowable<List<PersonEntity>> getFavoritePersons();

    /**
     * Receiving person details by id
     *
     * @param personId - a person id
     * @return {@link Single} with person details
     */
    @Query("SELECT * FROM Persons WHERE id = :personId")
    Single<PersonEntity> getPersonById(final int personId);

    /**
     * Deleting person by id
     *
     * @param personId - a person id
     */
    @Query("DELETE FROM Persons WHERE id = :personId")
    void deletePersonById(final int personId);

    /**
     * Deleting all persons
     */
    @Query("DELETE FROM Persons")
    void clearPersons();

    /**
     * Adding person, replacing on conflicts {@link OnConflictStrategy}
     *
     * @param personEntity - a person to add
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPerson(final PersonEntity personEntity);

    /**
     * Updating person
     *
     * @param personEntity - a person to update
     */
    @Update
    void updatePerson(final PersonEntity personEntity);
}
