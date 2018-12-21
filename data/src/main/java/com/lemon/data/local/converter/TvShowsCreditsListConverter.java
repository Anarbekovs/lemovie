package com.lemon.data.local.converter;

import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lemon.data.local.entity.credits.TvShowCredit;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A Room-Converter class {@link TypeConverter} to save {@link ArrayList<TvShowCredit>} into {@link RoomDatabase}
 */
public final class TvShowsCreditsListConverter {

    /**
     * Convert {@link String} to {@link List<TvShowCredit>} with {@link Gson}.
     *
     * @param jsonStr - a string for conversion
     * @return converted list of tv show credits {@link TvShowCredit}
     */
    @TypeConverter
    public static List<TvShowCredit> toCastCreditList(final String jsonStr) {
        final Type listType = new TypeToken<ArrayList<TvShowCredit>>() {
        }.getType();
        return new Gson().fromJson(jsonStr, listType);
    }

    /**
     * Convert {@link List<TvShowCredit>} to {@link String} with {@link Gson}.
     *
     * @param list - a list of tv show credits {@link TvShowCredit} for conversion
     * @return converted string
     */
    @TypeConverter
    public static String toJsonString(final List<TvShowCredit> list) {
        final Gson gson = new Gson();
        return gson.toJson(list);
    }
}
