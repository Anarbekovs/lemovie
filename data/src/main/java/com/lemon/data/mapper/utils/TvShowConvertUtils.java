package com.lemon.data.mapper.utils;

import com.lemon.data.local.entity.credits.PersonCredit;
import com.lemon.data.remote.api.TMDbApi;
import com.lemon.data.remote.pojo.tvshow.detail.Cast;
import com.lemon.data.remote.pojo.tvshow.detail.Creator;
import com.lemon.data.remote.pojo.tvshow.detail.Genres;
import com.lemon.data.remote.pojo.tvshow.detail.Network;
import com.lemon.data.remote.pojo.tvshow.detail.Poster;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class which provides methods for converting TvShow properties
 */
public final class TvShowConvertUtils {

    private static final String TV_ORIGINAL_IMAGE_SIZE = "original";
    private static final String TV_PREVIEW_IMAGE_SIZE = "w200";

    private static final String JOB_CREATOR = "Creator";

    private static final int ELEM_OFFSET = 1;
    private static final int NETWORKS_MAX = 2;
    private static final int GENRES_MAX = 3;

    /**
     * Converts url for original tv show image poster
     *
     * @param path - a part of url
     * @return total url for load original image poster
     */
    public static String convertOriginalImageUrl(final String path) {
        if (path != null) {
            return TMDbApi.IMAGES_URL + TV_ORIGINAL_IMAGE_SIZE + path;
        }
        return null;
    }

    /**
     * Converts url for preview (w200) tv show image poster
     *
     * @param path - a part of url
     * @return total url for load preview image poster
     */
    public static String convertPreviewImageUrl(final String path) {
        if (path != null) {
            return TMDbApi.IMAGES_URL + TV_PREVIEW_IMAGE_SIZE + path;
        }
        return null;
    }

    /**
     * Converts list of genres {@link List<Genres>} to list of genre names {@link List<String>} with GENRES_MAX restriction.
     *
     * @param genresList - a list of genres
     * @return list of genre names
     */
    public static List<String> convertGenres(final List<Genres> genresList) {
        final int size = genresList.size() > GENRES_MAX ? GENRES_MAX : genresList.size();
        final List<String> genres = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            if (genresList.get(i).getName() != null) {
                genres.add(genresList.get(i).getName());
            }
        }
        return genres;
    }

    /**
     * Converts list of posters {@link List<Poster>} to list of poster urls {@link List<String>}
     *
     * @param postersList - a list of posters
     * @return list of poster urls
     */
    public static List<String> convertPosters(final List<Poster> postersList) {
        final List<String> posters = new ArrayList<>();
        for (final Poster poster : postersList) {
            if (poster.getFilePath() != null) {
                posters.add(convertOriginalImageUrl(poster.getFilePath()));
            }
        }
        return posters;
    }

    /**
     * Converts list of networks {@link List<Network>} to string of network names {@link List<String>}
     * with NETWORKS_MAX restriction.
     *
     * @param networkList - a list of networks
     * @return string of networks names
     */
    public static String convertNetworks(final List<Network> networkList) {
        if (networkList != null) {
            final StringBuilder networks = new StringBuilder();
            final int size = networkList.size() > NETWORKS_MAX ? NETWORKS_MAX : networkList.size();
            for (int i = 0; i < size; i++) {
                networks.append(networkList.get(i).getName());
                if (i != networkList.size() - ELEM_OFFSET) {
                    networks.append(", ");
                }
            }
            return networks.toString();
        }
        return null;
    }

    /**
     * Converts episodes runtime to average value (in minutes)
     *
     * @param episodesRuntime - a list of episodes runtime
     * @return average value of episodes runtime in minutes
     */
    public static int convertEpisodesRuntime(final List<Integer> episodesRuntime) {
        int averageRuntime = 0;
        int episodes = episodesRuntime.size();
        if (episodes != 0) {
            for (int runtime : episodesRuntime) {
                averageRuntime += runtime;
            }
            averageRuntime = averageRuntime / episodes;
        }
        return averageRuntime;
    }

    /**
     * Converts list of tv show creators crew {@link List<Creator>} to list of person credits {@link List<PersonCredit>}
     *
     * @param creatorList - a list of tv show creators crew
     * @return list of person credits
     */
    public static List<PersonCredit> convertCreators(final List<Creator> creatorList) {
        final List<PersonCredit> creators = new ArrayList<>();
        for (final Creator creator : creatorList) {
            creators.add(new PersonCredit(
                    creator.getId(),
                    creator.getName(),
                    JOB_CREATOR,
                    convertPreviewImageUrl(creator.getProfilePath())
            ));
        }
        return creators;
    }

    /**
     * Converts list of tv show actors cast {@link List<Cast>} to list of person credits {@link List<PersonCredit>}
     *
     * @param castList - a list of tv show actors cast
     * @return list of person credits
     */
    public static List<PersonCredit> convertCastToActorsCredits(final List<Cast> castList) {
        final List<PersonCredit> actorsCredits = new ArrayList<>();
        for (final Cast cast : castList) {
            actorsCredits.add(new PersonCredit(
                    cast.getId(),
                    cast.getName(),
                    cast.getCharacter(),
                    convertPreviewImageUrl(cast.getProfilePath())
            ));
        }
        return actorsCredits;
    }

    private TvShowConvertUtils() {
    }
}
