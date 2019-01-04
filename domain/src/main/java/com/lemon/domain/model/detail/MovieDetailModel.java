package com.lemon.domain.model.detail;

import com.lemon.domain.model.detail.credits.PersonCreditModel;

import java.util.List;

/**
 * Model that represents MovieDetail in domain-layer
 */
public final class MovieDetailModel {

    private final int mId;
    private final String mTitle;
    private final String mOriginalTitle;
    private final String mTagLine;
    private final String mReleaseDate;
    private final List<String> mGenres;
    private final String mPoster;
    private final String mPosterPreview;
    private final String mAllPosters;
    private final String mDescription;
    private final int mBudget;
    private final long mRevenue;
    private final String mStatus;
    private final String mLanguage;
    private final int mRuntime;
    private final double mRating;
    private final double mTmdbRating;
    private final int mVotesCount;
    private final boolean mWatchlist;
    private final boolean mFavorite;
    private final String mYoutubeKey;
    private final List<PersonCreditModel> mCast;
    private final List<PersonCreditModel> mCrew;

    public MovieDetailModel(int id, String title, String originalTitle,
                            String tagLine, String releaseDate, List<String> genres,
                            String poster, String posterPreview, String allPosters,
                            String description, int budget, long revenue, String status,
                            String language, int runtime, double rating, double tmdbRating,
                            int votesCount, boolean isWatchlist, boolean isFavorite,
                            List<PersonCreditModel> cast, List<PersonCreditModel> crew,String youtubeKey) {
        this.mId = id;
        this.mTitle = title;
        this.mOriginalTitle = originalTitle;
        this.mTagLine = tagLine;
        this.mReleaseDate = releaseDate;
        this.mGenres = genres;
        this.mPoster = poster;
        this.mPosterPreview = posterPreview;
        this.mAllPosters = allPosters;
        this.mDescription = description;
        this.mBudget = budget;
        this.mRevenue = revenue;
        this.mStatus = status;
        this.mLanguage = language;
        this.mRuntime = runtime;
        this.mRating = rating;
        this.mTmdbRating = tmdbRating;
        this.mVotesCount = votesCount;
        this.mWatchlist = isWatchlist;
        this.mFavorite = isFavorite;
        this.mCast = cast;
        this.mCrew = crew;
        this.mYoutubeKey = youtubeKey;
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

    public String getTagLine() {
        return mTagLine;
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

    public String getAllPosters() {
        return mAllPosters;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getBudget() {
        return mBudget;
    }

    public long getRevenue() {
        return mRevenue;
    }

    public String getStatus() {
        return mStatus;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public int getRuntime() {
        return mRuntime;
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

    public String getYoutubeKey() {
        return mYoutubeKey;
    }

    public boolean isWatchlist() {
        return mWatchlist;
    }

    public boolean isFavorite() {
        return mFavorite;
    }

    public List<PersonCreditModel> getCast() {
        return mCast;
    }

    public List<PersonCreditModel> getCrew() {
        return mCrew;
    }

}
