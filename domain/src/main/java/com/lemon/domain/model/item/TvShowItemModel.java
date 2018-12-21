package com.lemon.domain.model.item;

import java.util.List;

/**
 * Model that represents TvShowItem in domain-layer
 */
public final class TvShowItemModel {

    private final int mId;
    private final String mTitle;
    private final String mPoster;
    private final String mReleaseDate;
    private final List<String> mGenres;
    private final double mRating;
    private final double mTmdbRating;

    public TvShowItemModel(int id, String title, String poster, String releaseDate,
                           List<String> genres, double rating, double tmdbRating) {
        this.mId = id;
        this.mTitle = title;
        this.mPoster = poster;
        this.mReleaseDate = releaseDate;
        this.mGenres = genres;
        this.mRating = rating;
        this.mTmdbRating = tmdbRating;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getPoster() {
        return mPoster;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public List<String> getGenres() {
        return mGenres;
    }

    public double getRating() {
        return mRating;
    }

    public double getTmdbRating() {
        return mTmdbRating;
    }
}
