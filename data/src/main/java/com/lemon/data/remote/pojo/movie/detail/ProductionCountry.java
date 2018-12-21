package com.lemon.data.remote.pojo.movie.detail;

import com.google.gson.annotations.SerializedName;

public final class ProductionCountry {

    @SerializedName("iso_3166_1")
    private String mIso31661;

    @SerializedName("name")
    private String mName;

    public String getIso31661() {
        return mIso31661;
    }

    public String getName() {
        return mName;
    }
}