package com.lemon.data.remote.pojo.movie.detail;

import com.google.gson.annotations.SerializedName;

public final class Crew {

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

    @SerializedName("department")
    private String mDepartment;

    @SerializedName("job")
    private String mJob;

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

    public String getDepartment() {
        return mDepartment;
    }

    public String getJob() {
        return mJob;
    }
}