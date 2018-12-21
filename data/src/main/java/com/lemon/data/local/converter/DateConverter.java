package com.lemon.data.local.converter;

import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * A Room-Converter class {@link TypeConverter} to save {@link Date} into {@link RoomDatabase}
 */
public final class DateConverter {

    /**
     * Convert {@link Long} to {@link Date}
     *
     * @param value - a date value in millis
     * @return converted date
     */
    @TypeConverter
    public static Date toDate(final Long value) {
        return value == null ? null : new Date(value);
    }

    /**
     * Convert {@link Date} to {@link Long}
     *
     * @param date - a date {@link Date} for conversion
     * @return date value in millis
     */
    @TypeConverter
    public static Long fromDate(final Date date) {
        return date == null ? null : date.getTime();
    }
}
