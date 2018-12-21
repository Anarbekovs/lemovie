package com.lemon.data.remote.pojo.tvshow.find;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class TvShowResult {

    @SerializedName("id")
    private int mId;

    @SerializedName("first_air_date")
    private String mFirstAirDate;

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("original_language")
    private String mOriginalLanguage;

    @SerializedName("genre_ids")
    private List<Integer> mGenreIds;

    @SerializedName("poster_path")
    private String mPosterPath;

    @SerializedName("origin_country")
    private List<String> mOriginCountry;

    @SerializedName("backdrop_path")
    private String mBackdropPath;

    @SerializedName("original_name")
    private String mOriginalName;

    @SerializedName("popularity")
    private double mPopularity;

    @SerializedName("vote_average")
    private double mVoteAverage;

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

    public String getOriginalName() {
        return mOriginalName;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public String getName() {
        return mName;
    }

    public int getVoteCount() {
        return mVoteCount;
    }
}