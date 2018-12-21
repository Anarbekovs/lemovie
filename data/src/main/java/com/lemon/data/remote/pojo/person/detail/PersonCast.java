package com.lemon.data.remote.pojo.person.detail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class PersonCast {

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("original_language")
    private String mOriginalLanguage;

    @SerializedName("original_title")
    private String mOriginalTitle;

    @SerializedName("video")
    private boolean mVideo;

    @SerializedName(value = "title", alternate = {"name"})
    private String mTitle;

    @SerializedName("genre_ids")
    private List<Integer> mGenreIds;

    @SerializedName("poster_path")
    private String mPosterPath;

    @SerializedName("backdrop_path")
    private String mBackdropPath;

    @SerializedName("character")
    private String mCharacter;

    @SerializedName("release_date")
    private String mReleaseDate;

    @SerializedName("credit_id")
    private String mCreditId;

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

    public String getCharacter() {
        return mCharacter;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getCreditId() {
        return mCreditId;
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