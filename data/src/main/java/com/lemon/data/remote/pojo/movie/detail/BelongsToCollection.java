package com.lemon.data.remote.pojo.movie.detail;

import com.google.gson.annotations.SerializedName;

public final class BelongsToCollection {

    @SerializedName("backdrop_path")
    private String mBackdropPath;

    @SerializedName("name")
    private String mName;

    @SerializedName("id")
    private int mId;

    @SerializedName("poster_path")
    private String mPosterPath;


    public String getBackdropPath() {
        return mBackdropPath;
    }

    public String getName() {
        return mName;
    }

    public int getId() {
        return mId;
    }

    public String getPosterPath() {
        return mPosterPath;
    }
}