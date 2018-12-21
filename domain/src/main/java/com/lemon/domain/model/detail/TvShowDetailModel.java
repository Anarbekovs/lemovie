package com.lemon.domain.model.detail;

import com.lemon.domain.model.detail.credits.PersonCreditModel;

import java.util.List;

/**
 * Model that represents TvShowDetail in domain-layer
 */
public final class TvShowDetailModel {

    private final int mId;
    private final String mTitle;
    private final String mOriginalTitle;
    private final String mReleaseDate;
    private final List<String> mGenres;
    private final String mPoster;
    private final String mPosterPreview;
    private final List<String> mAllPosters;
    private final String mDescription;
    private final String mStatus;
    private final boolean mIsInProduction;
    private final int mEpisodesCount;
    private final int mSeasonsCount;
    private final String mLanguage;
    private final String mNetwork;
    private final int mEpisodeRuntime;
    private final double mRating;
    private final double mTmdbRating;
    private final int mVotesCount;
    private final boolean mWatchlist;
    private final boolean mFavorite;
    private final List<PersonCreditModel> mCreators;
    private final List<PersonCreditModel> mActors;

    public TvShowDetailModel(int id, String title, String originalTitle,
                             String releaseDate, List<String> genres, String poster,
                             String posterPreview, List<String> allPosters, String description,
                             String status, boolean isInProduction, int episodesCount, int seasonsCount,
                             String language, String network, int episodeRuntime, double rating, double tmdbRating,
                             int votesCount, boolean isWatchlist, boolean isFavorite, List<PersonCreditModel> creators,
                             List<PersonCreditModel> actors) {
        this.mId = id;
        this.mTitle = title;
        this.mOriginalTitle = originalTitle;
        this.mReleaseDate = releaseDate;
        this.mGenres = genres;
        this.mPoster = poster;
        this.mPosterPreview = posterPreview;
        this.mAllPosters = allPosters;
        this.mDescription = description;
        this.mStatus = status;
        this.mIsInProduction = isInProduction;
        this.mEpisodesCount = episodesCount;
        this.mSeasonsCount = seasonsCount;
        this.mLanguage = language;
        this.mNetwork = network;
        this.mEpisodeRuntime = episodeRuntime;
        this.mRating = rating;
        this.mTmdbRating = tmdbRating;
        this.mVotesCount = votesCount;
        this.mWatchlist = isWatchlist;
        this.mFavorite = isFavorite;
        this.mCreators = creators;
        this.mActors = actors;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public List<String> getGenres() {
        return mGenres;
    }

    public String getPoster() {
        return mPoster;
    }

    public String getPosterPreview() {
        return mPosterPreview;
    }

    public List<String> getAllPosters() {
        return mAllPosters;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getStatus() {
        return mStatus;
    }

    public boolean isInProduction() {
        return mIsInProduction;
    }

    public int getEpisodesCount() {
        return mEpisodesCount;
    }

    public int getSeasonsCount() {
        return mSeasonsCount;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public String getNetwork() {
        return mNetwork;
    }

    public int getEpisodeRuntime() {
        return mEpisodeRuntime;
    }

    public double getRating() {
        return mRating;
    }

    public double getTmdbRating() {
        return mTmdbRating;
    }

    public int getVotesCount() {
        return mVotesCount;
    }

    public boolean isWatchlist() {
        return mWatchlist;
    }

    public boolean isFavorite() {
        return mFavorite;
    }

    public List<PersonCreditModel> getCreators() {
        return mCreators;
    }

    public List<PersonCreditModel> getActors() {
        return mActors;
    }
}
