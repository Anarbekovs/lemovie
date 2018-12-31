package com.lemon.lemonmovies.mapper.utils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

/**
 * Converting utility class
 */
public final class ConvertUtils {

    private static final String RATING_FORMAT = "%.1f/10";
    private static final String TMDB_RATING_FORMAT = "%.1f";
    private static final String MOVIE_AMOUNT_FORMAT = "$ #,##0";
    private static final String MOVIE_INFO_FORMAT = "%s | %d min | %s";
    private static final String TV_SHOW_INFO_FORMAT = "%d (%d) | %d min";
    private static final String TV_SHOW_NETWORK_INFO_FORMAT = "%s | %s";

    private static final int ELEM_OFFSET = 1;
    private static final int GENRES_ITEM_MAX = 4;

    /**
     * Converts list of genre names {@link List<String>} to item genres string
     *
     * @param genresList - a list of genre names
     * @return converted string of item genres
     */
    public static String convertItemGenresToString(final List<String> genresList) {
        final StringBuilder genres = new StringBuilder();
        final int size = genresList.size() > GENRES_ITEM_MAX ? GENRES_ITEM_MAX : genresList.size();
        for (int i = 0; i < size; i++) {
            genres.append(genresList.get(i));
            if (i != size - ELEM_OFFSET) {
                genres.append(", ");
            }
        }
        return genres.toString();
    }

    /**
     * Converts movie info field with movie language, runtime and status
     *
     * @param language - a spoken movie language
     * @param runtime  - a movie runtime
     * @param status   - a movie status
     * @return converted string of movie info
     */
    public static String convertMovieInfo(final String language, final int runtime, final String status) {
        return String.format(Locale.getDefault(), MOVIE_INFO_FORMAT, language, runtime, status);
    }

    /**
     * Converts tv show info field with tv show seasons count, episodes count and avg runtime
     *
     * @param seasons  - a tv show seasons count
     * @param episodes - a tv show episodes count
     * @param runtime  - a tv show avg runtime
     * @return converted string of tv show info
     */
    public static String convertTvShowInfo(final int seasons, final int episodes, final int runtime) {
        return String.format(Locale.getDefault(), TV_SHOW_INFO_FORMAT, seasons, episodes, runtime);
    }

    /**
     * Converts tv show network info field with tv show spoken language and network label
     *
     * @param language - a spoken tv show language
     * @param network - a tv show network label
     * @return converted string of tv show network info
     */
    public static String convertTvShowNetworkInfo(final String language, final String network) {
        return String.format(Locale.getDefault(), TV_SHOW_NETWORK_INFO_FORMAT, language, network);
    }

    /**
     * Converts movie budget/revenue amount with dollars sign and correct decimal format
     *
     * @param amount - a movie amount with budget or revenue sum
     * @return converted movie amount
     */
    public static String convertMovieAmount(final long amount) {
        return new DecimalFormat(MOVIE_AMOUNT_FORMAT).format(amount);
    }

    /**
     * Converts rating for showing into view
     *
     * @param rating - a rating
     * @return converted rating
     */
    public static String convertRating(final double rating) {
        return String.format(Locale.getDefault(), RATING_FORMAT, rating)
                .replaceAll(",", ".");
    }

    /**
     * Converts tmdb rating for showing into view
     *
     * @param rating - a tmdb rating
     * @return converted tmdb rating
     */
    public static String convertTmdbRating(final double rating) {
        return String.format(Locale.getDefault(), TMDB_RATING_FORMAT, rating)
                .replaceAll(",", ".");
    }

    private ConvertUtils() {
    }
}
