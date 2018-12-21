package com.lemon.data.remote.pojo.tvshow.detail;

import com.google.gson.annotations.SerializedName;

public final class Poster {

    @SerializedName("aspect_ratio")
    private double mAspectRatio;

    @SerializedName("file_path")
    private String mFilePath;

    @SerializedName("vote_average")
    private double mVoteAverage;

    @SerializedName("width")
    private int mWidth;

    @SerializedName("iso_639_1")
    private String mIso6391;

    @SerializedName("vote_count")
    private int mVoteCount;

    @SerializedName("height")
    private int mHeight;

    public double getAspectRatio() {
        return mAspectRatio;
    }

    public String getFilePath() {
        return mFilePath;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public int getWidth() {
        return mWidth;
    }

    public String getIso6391() {
        return mIso6391;
    }

    public int getVoteCount() {
        return mVoteCount;
    }

    public int getHeight() {
        return mHeight;
    }
}