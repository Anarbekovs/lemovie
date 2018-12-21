package com.lemon.data.remote.pojo.tvshow.detail;

import com.google.gson.annotations.SerializedName;

public final class LastEpisodeToAir {

    @SerializedName("id")
    private int mId;

    @SerializedName("air_date")
    private String mAirDate;

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("episode_number")
    private int mEpisodeNumber;

    @SerializedName("show_id")
    private int mShowId;

    @SerializedName("vote_average")
    private double mVoteAverage;

    @SerializedName("name")
    private String mName;

    @SerializedName("season_number")
    private int mSeasonNumber;

    @SerializedName("still_path")
    private String mStillPath;

    @SerializedName("vote_count")
    private int mVoteCount;

    public int getId() {
        return mId;
    }

    public String getAirDate() {
        return mAirDate;
    }

    public String getOverview() {
        return mOverview;
    }

    public int getEpisodeNumber() {
        return mEpisodeNumber;
    }

    public int getShowId() {
        return mShowId;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public String getName() {
        return mName;
    }

    public int getSeasonNumber() {
        return mSeasonNumber;
    }

    public String getStillPath() {
        return mStillPath;
    }

    public int getVoteCount() {
        return mVoteCount;
    }
}