package com.lemon.data.mapper.utils;

import com.lemon.data.local.entity.credits.MovieCredit;
import com.lemon.data.local.entity.credits.TvShowCredit;
import com.lemon.data.remote.api.TMDbApi;
import com.lemon.data.remote.pojo.person.detail.PersonCast;
import com.lemon.data.remote.pojo.person.detail.PersonCrew;
import com.lemon.data.remote.pojo.person.find.KnownFor;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class which provides methods for converting Person properties
 */
public final class PersonConvertUtils {

    private static final String ORIGINAL_IMAGE_SIZE = "original";
    private static final String PREVIEW_IMAGE_SIZE = "w200";

    private static final String ACTING_DEPARTMENT = "Acting";

    /**
     * Converts url for original person image photo
     *
     * @param path - a part of url
     * @return total url for load original image photo
     */
    public static String convertOriginalImageUrl(final String path) {
        if (path != null) {
            return TMDbApi.IMAGES_URL + ORIGINAL_IMAGE_SIZE + path;
        }
        return null;
    }

    /**
     * Converts url for preview (w200) person image photo
     *
     * @param path - a part of url
     * @return total url for load preview image photo
     */
    public static String convertPreviewImageUrl(final String path) {
        if (path != null) {
            return TMDbApi.IMAGES_URL + PREVIEW_IMAGE_SIZE + path;
        }
        return null;
    }

    /**
     * Converts person's cast filmography {@link List<PersonCast>} to list of tv show credits {@link List<TvShowCredit>}
     *
     * @param personCastList - a list of full person's cast
     * @return list of tv show credits
     */
    public static List<TvShowCredit> convertCastToTvShowsCredits(final List<PersonCast> personCastList) {
        final List<TvShowCredit> tvShowCredits = new ArrayList<>();
        for (final PersonCast cast : personCastList) {
            tvShowCredits.add(new TvShowCredit(
                    cast.getId(),
                    cast.getTitle(),
                    cast.getCharacter(),
                    convertPreviewImageUrl(cast.getPosterPath())
            ));
        }
        return tvShowCredits;
    }

    /**
     * Converts person's crew filmography {@link List<PersonCrew>} to list of tv show credits {@link List<TvShowCredit>}
     *
     * @param personCrewList - a list of full person's crew
     * @return list of tv show credits
     */
    public static List<TvShowCredit> convertCrewToTvShowsCredits(final List<PersonCrew> personCrewList) {
        final List<TvShowCredit> tvShowCredits = new ArrayList<>();
        for (final PersonCrew cast : personCrewList) {
            tvShowCredits.add(new TvShowCredit(
                    cast.getId(),
                    cast.getTitle(),
                    cast.getJob(),
                    convertPreviewImageUrl(cast.getPosterPath())
            ));
        }
        return tvShowCredits;
    }

    /**
     * Converts person's cast filmography {@link List<PersonCast>} to list of movie credits {@link List<MovieCredit>}
     *
     * @param personCastList - a list of full person's cast
     * @return list of movie credits
     */
    public static List<MovieCredit> convertCastToMoviesCredits(final List<PersonCast> personCastList) {
        final List<MovieCredit> movieCredits = new ArrayList<>();
        for (final PersonCast cast : personCastList) {
            movieCredits.add(new MovieCredit(
                    cast.getId(),
                    cast.getTitle(),
                    cast.getCharacter(),
                    convertPreviewImageUrl(cast.getPosterPath())
            ));
        }
        return movieCredits;
    }

    /**
     * Converts person's crew filmography {@link List<PersonCrew>} to list of movie credits {@link List<MovieCredit>}
     *
     * @param personCrewList - a list of full person's crew
     * @return list of movie credits
     */
    public static List<MovieCredit> convertCrewToMoviesCredits(final List<PersonCrew> personCrewList) {
        final List<MovieCredit> movieCredits = new ArrayList<>();
        for (final PersonCrew cast : personCrewList) {
            movieCredits.add(new MovieCredit(
                    cast.getId(),
                    cast.getTitle(),
                    cast.getJob(),
                    convertPreviewImageUrl(cast.getPosterPath())
            ));
        }
        return movieCredits;
    }

    /**
     * Converts list of 'known for' {@link List<KnownFor>} to string of movie or tv show title
     * on which this person is most known.
     *
     * @param knownForList - a list of 'known for' titles
     * @return string of movie or tv show title
     */
    public static String convertKnownForDesc(final List<KnownFor> knownForList) {
        if (knownForList == null) {
            return null;
        }

        int knownForIndex = 0;
        double popularity = 0;

        for (int i = 0; i < knownForList.size(); i++) {
            final KnownFor knownForItem = knownForList.get(i);
            if (knownForItem.getPopularity() > popularity) {
                popularity = knownForItem.getPopularity();
                knownForIndex = i;
            }
        }

        return knownForList.get(knownForIndex).getTitle();
    }

    /**
     * Checks person is actor
     *
     * @param knownForDepartment string which represents what department knows about this person
     * @return {@code true} - if person is actor,
     * {@code false} - if person is not actor
     */
    public static boolean isActor(final String knownForDepartment) {
        return knownForDepartment.equalsIgnoreCase(ACTING_DEPARTMENT);
    }

    private PersonConvertUtils() {
    }
}
