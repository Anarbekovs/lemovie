package com.lemon.data.remote.pojo.credits;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class TVShowsCredits {

    @SerializedName("id")
    private int mId;

    @SerializedName("first_air_date")
    private String mFirstAirDate;

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("original_language")
    private String mOriginalLanguage;

    @SerializedName("episode_count")
    private int mEpisodeCount;

    @SerializedName("genre_ids")
    private List<Integer> mGenreIds;

    @SerializedName("poster_path")
    private String mPosterPath;

    @SerializedName("origin_country")
    private List<String> mOriginCountry;

    @SerializedName("backdrop_path")
    private String mBackdropPath;

    @SerializedName("character")
    private String mCharacter;

    @SerializedName("credit_id")
    private String mCreditId;

    @SerializedName("original_name")
    private String mOriginalName;

    @SerializedName("vote_average")
    private double mVoteAverage;

    @SerializedName("popularity")
    private double mPopularity;

    @SerializedName("name")
    private String mName;

    @SerializedName("vote_count")
    private int mVoteCount;

    public int getId() {
        return mId;
    }

    public String getFirstAirDate() {
        return mFirstAirDate;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getOriginalLanguage() {
        return mOriginalLanguage;
    }

    public int getEpisodeCount() {
        return mEpisodeCount;
    }

    public List<Integer> getGenreIds() {
        return mGenreIds;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public List<String> getOriginCountry() {
        return mOriginCountry;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public String getCharacter() {
        return mCharacter;
    }

    public String getCreditId() {
        return mCreditId;
    }

    public String getOriginalName() {
        return mOriginalName;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public String getName() {
        return mName;
    }

    public int getVoteCount() {
        return mVoteCount;
    }
}