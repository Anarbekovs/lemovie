package com.lemon.data.remote.pojo.tvshow.detail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class TvShowDetail {

    @SerializedName("id")
    private int mId;

    @SerializedName("original_language")
    private String mOriginalLanguage;

    @SerializedName("number_of_episodes")
    private int mNumberOfEpisodes;

    @SerializedName("networks")
    private List<Network> mNetworks;

    @SerializedName("type")
    private String mType;

    @SerializedName("backdrop_path")
    private String mBackdropPath;

    @SerializedName("genres")
    private List<Genres> mGenres;

    @SerializedName("popularity")
    private double mPopularity;

    @SerializedName("number_of_seasons")
    private int mNumberOfSeasons;

    @SerializedName("vote_count")
    private int mVoteCount;

    @SerializedName("first_air_date")
    private String mFirstAirDate;

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("seasons")
    private List<Seasons> mSeasons;

    @SerializedName("languages")
    private List<String> mLanguages;

    @SerializedName("created_by")
    private List<Creator> mCreatedBy;

    @SerializedName("last_episode_to_air")
    private LastEpisodeToAir mLastEpisodeToAir;

    @SerializedName("poster_path")
    private String mPosterPath;

    @SerializedName("origin_country")
    private List<String> mOriginCountry;

    @SerializedName("production_companies")
    private List<ProductionCompany> mProductionCompanies;

    @SerializedName("original_name")
    private String mOriginalTitle;

    @SerializedName("vote_average")
    private double mVoteAverage;

    @SerializedName("name")
    private String mTitle;

    @SerializedName("episode_run_time")
    private List<Integer> mEpisodeRunTime;

    @SerializedName("next_episode_to_air")
    private NextEpisodeToAir mNextEpisodeToAir;

    @SerializedName("in_production")
    private boolean mInProduction;

    @SerializedName("last_air_date")
    private String mLastAirDate;

    @SerializedName("homepage")
    private String mHomepage;

    @SerializedName("status")
    private String mStatus;

    @SerializedName("images")
    private Images mImages;

    @SerializedName("credits")
    private Credits mCredits;

    public int getId() {
        return mId;
    }

    public String getOriginalLanguage() {
        return mOriginalLanguage;
    }

    public int getNumberOfEpisodes() {
        return mNumberOfEpisodes;
    }

    public List<Network> getNetworks() {
        return mNetworks;
    }

    public String getType() {
        return mType;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public List<Genres> getGenres() {
        return mGenres;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public int getNumberOfSeasons() {
        return mNumberOfSeasons;
    }

    public int getVoteCount() {
        return mVoteCount;
    }

    public String getFirstAirDate() {
        return mFirstAirDate;
    }

    public String getOverview() {
        return mOverview;
    }

    public List<Seasons> getSeasons() {
        return mSeasons;
    }

    public List<String> getLanguages() {
        return mLanguages;
    }

    public List<Creator> getCreatedBy() {
        return mCreatedBy;
    }

    public LastEpisodeToAir getLastEpisodeToAir() {
        return mLastEpisodeToAir;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public List<String> getOriginCountry() {
        return mOriginCountry;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return mProductionCompanies;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public String getTitle() {
        return mTitle;
    }

    public List<Integer> getEpisodeRunTime() {
        return mEpisodeRunTime;
    }

    public NextEpisodeToAir getNextEpisodeToAir() {
        return mNextEpisodeToAir;
    }

    public boolean isInProduction() {
        return mInProduction;
    }

    public String getLastAirDate() {
        return mLastAirDate;
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