package com.lemon.data.remote.pojo.movie.detail;

import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("key")
    private String mKey;

    @SerializedName("type")
    private String mType;

    public String getKey() {
        return mKey;
    }

    public String getType() {
        return mType;
    }
}
