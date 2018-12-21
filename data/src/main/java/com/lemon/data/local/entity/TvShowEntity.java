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
 * TvShow Entity
 */
@Entity(tableName = "TVShows")
public final class TvShowEntity {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private final int mId;

    @ColumnInfo(name = "title")
    private final String mTitle;

    @ColumnInfo(name = "original_title")
    private final String mOriginalTitle;

    @ColumnInfo(name = "first_air_date")
    private final String mFirstAirDate;

    @ColumnInfo(name = "genres")
    @TypeConverters(ArrayListConverter.class)
    private final List<String> mGenres;

    @ColumnInfo(name = "poster")
    private final String mPoster;

    @ColumnInfo(name = "poster_preview")
    private final String mPosterPreview;

    @ColumnInfo(name = "posters")
    @TypeConverters(ArrayListConverter.class)
    private final List<String> mAllPosters;

    @ColumnInfo(name = "description")
    private final String mDescription;

    @ColumnInfo(name = "status")
    private final String mStatus;

    @ColumnInfo(name = "is_in_production")
    private final boolean mIsInProduction;

    @ColumnInfo(name = "episodes_count")
    private final int mEpisodesCount;

    @ColumnInfo(name = "seasons_count")
    private final int mSeasonsCount;

    @ColumnInfo(name = "language")
    private final String mLanguage;

    @ColumnInfo(name = "network")
    private final String mNetwork;

    @ColumnInfo(name = "episode_runtime")
    private final int mEpisodeRuntime;

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

    @ColumnInfo(name = "creators")
    @TypeConverters(CastCreditListConverter.class)
    private final List<PersonCredit> mCreators;

    @ColumnInfo(name = "actors")
    @TypeConverters(CastCreditListConverter.class)
    private final List<PersonCredit> mActors;

    public TvShowEntity(int id, String title, String originalTitle,
                        String firstAirDate, List<String> genres, String poster,
                        String posterPreview, List<String> allPosters, String description,
                        String status, boolean isInProduction, int episodesCount, int seasonsCount,
                        String language, String network, int episodeRuntime, double tmdbRating,
                        int votesCount, List<PersonCredit> creators, List<PersonCredit> actors) {
        this.mId = id;
        this.mTitle = title;
        this.mOriginalTitle = originalTitle;
        this.mFirstAirDate = firstAirDate;
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
        this.mTmdbRating = tmdbRating;
        this.mVotesCount = votesCount;
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

    public String getFirstAirDate() {
        return mFirstAirDate;
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

    public boolean isIsInProduction() {
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

    public List<PersonCredit> getCreators() {
        return mCreators;
    }

    public List<PersonCredit> getActors() {
        return mActors;
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

    public void setCreationDate(final Date creationDate) {
        this.mCreationDate = creationDate;
    }
}
