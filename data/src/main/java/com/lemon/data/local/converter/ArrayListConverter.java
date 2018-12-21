package com.lemon.data.local.converter;

import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A Room-Converter class {@link TypeConverter} to save {@link ArrayList<String>} into {@link RoomDatabase}
 */
public final class ArrayListConverter {

    /**
     * Convert {@link String} to {@link List<String>} with {@link Gson}
     *
     * @param jsonStr - a string for conversion
     * @return converted list of strings
     */
    @TypeConverter
    public static List<String> toArrayList(final String jsonStr) {
        final Type listType = new TypeToken<ArrayList<String>>() {
        }.getType();
        return new Gson().fromJson(jsonStr, listType);
    }

    /**
     * Convert {@link List<String>} to {@link String} with {@link Gson}.
     *
     * @param list - list of strings for conversion
     * @return converted string
     */
    @TypeConverter
    public static String toJsonString(final List<String> list) {
        final Gson gson = new Gson();
        return gson.toJson(list);
    }
}
