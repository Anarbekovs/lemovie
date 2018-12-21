package com.lemon.data.remote.pojo.tvshow.detail;

import com.google.gson.annotations.SerializedName;

public final class ProductionCompany {

    @SerializedName("id")
    private int mId;

    @SerializedName("logo_path")
    private String mLogoPath;

    @SerializedName("name")
    private String mName;

    @SerializedName("origin_country")
    private String mOriginCountry;

    public int getId() {
        return mId;
    }

    public String getLogoPath() {
        return mLogoPath;
    }

    public String getName() {
        return mName;
    }

    public String getOriginCountry() {
        return mOriginCountry;
    }
}