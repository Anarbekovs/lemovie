package com.lemon.data.remote.pojo.movie.detail;

import com.google.gson.annotations.SerializedName;

public final class SpokenLanguage {

    @SerializedName("name")
    private String mName;

    @SerializedName("iso_639_1")
    private String mIso6391;

    public String getName() {
        return mName;
    }

    public String getIso6391() {
        return mIso6391;
    }
}