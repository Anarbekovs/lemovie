package com.lemon.data.remote.pojo.tvshow.detail;

import com.google.gson.annotations.SerializedName;

public final class Seasons {

    @SerializedName("id")
    private int mId;

    @SerializedName("air_date")
    private String mAirDate;

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("episode_count")
    private int mEpisodeCount;

    @SerializedName("name")
    private String mName;

    @SerializedName("season_number")
    private int mSeasonNumber;

    @SerializedName("poster_path")
    private String mPosterPath;

    public int getId() {
        return mId;
    }

    public String getAirDate() {
        return mAirDate;
    }

    public String getOverview() {
        return mOverview;
    }

    public int getEpisodeCount() {
        return mEpisodeCount;
    }

    public String getName() {
        return mName;
    }

    public int getSeasonNumber() {
        return mSeasonNumber;
    }

    public String getPosterPath() {
        return mPosterPath;
    }
}