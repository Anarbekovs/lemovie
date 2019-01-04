package com.lemon.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.lemon.data.local.converter.ArrayListConverter;
import com.lemon.data.local.converter.CastCreditListConverter;
import com.lemon.data.local.converter.DateConverter;
import com.lemon.data.local.entity.credits.PersonCredit;

import java.util.Date;
import java.util.List;

/**
 * Movie Entity
 */
@Entity(tableName = "Movies")
public final class MovieEntity {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private final int mId;

    @ColumnInfo(name = "title")
    private final String mTitle;

    @ColumnInfo(name = "original_title")
    private final String mOriginalTitle;

    @ColumnInfo(name = "tagline")
    private final String mTagLine;

    @ColumnInfo(name = "release_date")
    private final String mReleaseDate;

    @ColumnInfo(name = "genres")
    @TypeConverters(ArrayListConverter.class)
    private final List<String> mGenres;

    @ColumnInfo(name = "poster")
    private final String mPoster;

    @ColumnInfo(name = "poster_preview")
    private final String mPosterPreview;

    @ColumnInfo(name = "posters")
    @TypeConverters(ArrayListConverter.class)
    private final String mAllPosters;

    @ColumnInfo(name = "description")
    private final String mDescription;

    @ColumnInfo(name = "budget")
    private final int mBudget;

    @ColumnInfo(name = "revenue")
    private final long mRevenue;

    @ColumnInfo(name = "status")
    private final String mStatus;

    @ColumnInfo(name = "language")
    private final String mLanguage;

    @ColumnInfo(name = "runtime")
    private final int mRuntime;

    @ColumnInfo(name = "rating")
    private double mRating;

    @ColumnInfo(name = "tmdb_rating")
    private final double mTmdbRating;

    @ColumnInfo(name = "votes_count")
    private final int mVotesCount;

    @ColumnInfo(name = "recent")
    private boolean mRecent;

    @ColumnInfo(name = "watchlist")
    private boolean mWatchlist;

    @ColumnInfo(name = "favorite")
    private boolean mFavorite;

    @ColumnInfo(name = "creation_date")
    @TypeConverters(DateConverter.class)
    private Date mCreationDate;

    @ColumnInfo(name = "actors")
    @TypeConverters(CastCreditListConverter.class)
    private final List<PersonCredit> mActors;

    @ColumnInfo(name = "directors")
    @TypeConverters(CastCreditListConverter.class)
    private final List<PersonCredit> mDirectors;

    @ColumnInfo(name = "writers")
    @TypeConverters(CastCreditListConverter.class)
    private final List<PersonCredit> mWriters;


    @ColumnInfo(name = "youtube_key")
    private final String mYoutubeKey;


    public MovieEntity(int id, String title, String originalTitle,
                       String tagLine, String releaseDate, List<String> genres,
                       String poster, String posterPreview, String allPosters, String description,
                       int budget, long revenue, String status, String language,
                       int runtime, double tmdbRating, int votesCount, List<PersonCredit> actors,
                       List<PersonCredit> directors, List<PersonCredit> writers,String youtubeKey) {
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
        this.mTmdbRating = tmdbRating;
        this.mVotesCount = votesCount;
        this.mActors = actors;
        this.mDirectors = directors;
        this.mWriters = writers;
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

    public boolean isRecent() {
        return mRecent;
    }

    public boolean isWatchlist() {
        return mWatchlist;
    }

    public boolean isFavorite() {
        return mFavorite;
    }

    public Date getCreationDate() {
        return mCreationDate;
    }

    public List<PersonCredit> getActors() {
        return mActors;
    }

    public List<PersonCredit> getDirectors() {
        return mDirectors;
    }

    public List<PersonCredit> getWriters() {
        return mWriters;
    }

    public void setRating(final double rating) {
        this.mRating = rating;
    }

    public void setRecent(final boolean isRecent) {
        this.mRecent = isRecent;
    }

    public void setWatchlist(final boolean isWatchlist) {
        this.mWatchlist = isWatchlist;
    }

    public void setFavorite(final boolean isFavorite) {
        this.mFavorite = isFavorite;
    }

    public String getYoutubeKey() {
        return mYoutubeKey;
    }


    public void setCreationDate(final Date creationDate) {
        this.mCreationDate = creationDate;
    }
}
