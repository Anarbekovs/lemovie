package com.lemon.domain.model.result;

/**
 * Model that represents MovieResult in domain-layer
 */
public final class MovieResultModel {

    private final int mId;
    private final String mTitle;
    private final String mPoster;
    private final String mReleaseDate;

    public MovieResultModel(int id, String title, String poster, String releaseDate) {
        this.mId = id;
        this.mTitle = title;
        this.mPoster = poster;
        this.mReleaseDate = releaseDate;
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
}
