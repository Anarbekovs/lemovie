package com.lemon.data.remote.pojo.person.find;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class KnownFor {

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("original_language")
    private String mOriginalLanguage;

    @SerializedName("original_title")
    private String mOriginalTitle;

    @SerializedName("video")
    private boolean mVideo;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("genre_ids")
    private List<Integer> mGenreIds;

    @SerializedName("poster_path")
    private String mPosterPath;

    @SerializedName("backdrop_path")
    private String mBackdropPath;

    @SerializedName("media_type")
    private String mMediaType;

    @SerializedName("release_date")
    private String mReleaseDate;

    @SerializedName("vote_average")
    private double mVoteAverage;

    @SerializedName("popularity")
    private double mPopularity;

    @SerializedName("id")
    private int mId;

    @SerializedName("adult")
    private boolean mAdult;

    @SerializedName("vote_count")
    private int mVoteCount;

    public String getOverview() {
        return mOverview;
    }

    public String getOriginalLanguage() {
        return mOriginalLanguage;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public boolean isVideo() {
        return mVideo;
    }

    public String getTitle() {
        return mTitle;
    }

    public List<Integer> getGenreIds() {
        return mGenreIds;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public String getMediaType() {
        return mMediaType;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public int getId() {
        return mId;
    }

    public boolean isAdult() {
        return mAdult;
    }

    public int getVoteCount() {
        return mVoteCount;
    }
}