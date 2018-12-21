package com.lemon.data.remote.pojo.tvshow.detail;

import com.google.gson.annotations.SerializedName;

public final class Genres {

    @SerializedName("name")
    private String mName;

    @SerializedName("id")
    private int mId;

    public String getName() {
        return mName;
    }

    public int getId() {
        return mId;
    }
}