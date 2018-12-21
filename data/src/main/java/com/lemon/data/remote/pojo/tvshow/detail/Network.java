package com.lemon.data.remote.pojo.tvshow.detail;

import com.google.gson.annotations.SerializedName;

public final class Network {

    @SerializedName("logo_path")
    private String mLogoPath;

    @SerializedName("name")
    private String mName;

    @SerializedName("id")
    private int mId;

    @SerializedName("origin_country")
    private String mOriginCountry;

    public String getLogoPath() {
        return mLogoPath;
    }

    public String getName() {
        return mName;
    }

    public int getId() {
        return mId;
    }

    public String getOriginCountry() {
        return mOriginCountry;
    }
}