package com.lemon.data.remote.pojo.movie.detail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class MovieDetail {

    @SerializedName("id")
    private int mId;

    @SerializedName("original_language")
    private String mOriginalLanguage;

    @SerializedName("imdb_id")
    private String mImdbId;

    @SerializedName("video")
    private boolean mVideo;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("backdrop_path")
    private String mBackdropPath;

    @SerializedName("revenue")
    private long mRevenue;

    @SerializedName("genres")
    private List<Genres> mGenres;

    @SerializedName("popularity")
    private double mPopularity;

    @SerializedName("production_countries")
    private List<ProductionCountry> mProductionCountries;

    @SerializedName("vote_count")
    private int mVoteCount;

    @SerializedName("budget")
    private int mBudget;

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("original_title")
    private String mOriginalTitle;

    @SerializedName("runtime")
    private int mRuntime;

    @SerializedName("poster_path")
    private String mPosterPath;

    @SerializedName("spoken_languages")
    private List<SpokenLanguage> mSpokenLanguages;

    @SerializedName("production_companies")
    private List<ProductionCompany> mProductionCompanies;

    @SerializedName("release_date")
    private String mReleaseDate;

    @SerializedName("vote_average")
    private double mVoteAverage;

    @SerializedName("belongs_to_collection")
    private BelongsToCollection mBelongsToCollection;

    @SerializedName("tagline")
    private String mTagline;

    @SerializedName("adult")
    private boolean mAdult;

    @SerializedName("homepage")
    private String mHomepage;

    @SerializedName("status")
    private String mStatus;

    @SerializedName("images")
    private Images mImages;

    @SerializedName("credits")
    private Credits mCredits;

    public String getOriginalLanguage() {
        return mOriginalLanguage;
    }

    public String getImdbId() {
        return mImdbId;
    }

    public boolean isVideo() {
        return mVideo;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public long getRevenue() {
        return mRevenue;
    }

    public List<Genres> getGenres() {
        return mGenres;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public List<ProductionCountry> getProductionCountries() {
        return mProductionCountries;
    }

    public int getId() {
        return mId;
    }

    public int getVoteCount() {
        return mVoteCount;
    }

    public int getBudget() {
        return mBudget;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public int getRuntime() {
        return mRuntime;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public List<SpokenLanguage> getSpokenLanguages() {
        return mSpokenLanguages;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return mProductionCompanies;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public BelongsToCollection getBelongsToCollection() {
        return mBelongsToCollection;
    }

    public String getTagline() {
        return mTagline;
    }

    public boolean isAdult() {
        return mAdult;
    }

    public String getHomepage() {
        return mHomepage;
    }

    public String getStatus() {
        return mStatus;
    }

    public Images getImages() {
        return mImages;
    }

    public Credits getCredits() {
        return mCredits;
    }
}