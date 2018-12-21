package com.lemon.data.local.converter;

import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lemon.data.local.entity.credits.MovieCredit;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A Room-Converter class {@link TypeConverter} to save {@link ArrayList<MovieCredit>} into {@link RoomDatabase}
 */
public final class MoviesCreditsListConverter {

    /**
     * Convert {@link String} to {@link List<MovieCredit>} with {@link Gson}.
     *
     * @param jsonStr - a string for conversion
     * @return converted list of movie credits {@link MovieCredit}
     */
    @TypeConverter
    public static List<MovieCredit> toCastCreditList(final String jsonStr) {
        final Type listType = new TypeToken<ArrayList<MovieCredit>>() {
        }.getType();
        return new Gson().fromJson(jsonStr, listType);
    }

    /**
     * Convert {@link List<MovieCredit>} to {@link String} with {@link Gson}.
     *
     * @param list - a list of person credits {@link MovieCredit} for conversion
     * @return converted string
     */
    @TypeConverter
    public static String toJsonString(final List<MovieCredit> list) {
        final Gson gson = new Gson();
        return gson.toJson(list);
    }
}
