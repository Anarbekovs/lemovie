package com.lemon.data.local.converter;

import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lemon.data.local.entity.credits.PersonCredit;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A Room-Converter class {@link TypeConverter} to save {@link ArrayList<PersonCredit>} into {@link RoomDatabase}
 */
public final class CastCreditListConverter {

    /**
     * Convert {@link String} to {@link List<PersonCredit>} with {@link Gson}
     *
     * @param jsonStr - a string for conversion
     * @return converted list of person credits {@link PersonCredit}
     */
    @TypeConverter
    public static List<PersonCredit> toCastCreditList(final String jsonStr) {
        final Type listType = new TypeToken<ArrayList<PersonCredit>>() {
        }.getType();
        return new Gson().fromJson(jsonStr, listType);
    }

    /**
     * Convert {@link List<PersonCredit>} to {@link String} with {@link Gson}
     *
     * @param list - a list of person credits {@link PersonCredit} for conversion
     * @return converted string
     */
    @TypeConverter
    public static String toJsonString(final List<PersonCredit> list) {
        final Gson gson = new Gson();
        return gson.toJson(list);
    }
}
