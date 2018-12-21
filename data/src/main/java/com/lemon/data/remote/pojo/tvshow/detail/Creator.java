package com.lemon.data.remote.pojo.tvshow.detail;

import com.google.gson.annotations.SerializedName;

public final class Creator {

    @SerializedName("id")
    private int mId;

    @SerializedName("gender")
    private int mGender;

    @SerializedName("credit_id")
    private String mCreditId;

    @SerializedName("name")
    private String mName;

    @SerializedName("profile_path")
    private String mProfilePath;

    public int getId() {
        return mId;
    }

    public int getGender() {
        return mGender;
    }

    public String getCreditId() {
        return mCreditId;
    }

    public String getName() {
        return mName;
    }

    public String getProfilePath() {
        return mProfilePath;
    }
}