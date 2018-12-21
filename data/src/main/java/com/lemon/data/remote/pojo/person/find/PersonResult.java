package com.lemon.data.remote.pojo.person.find;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class PersonResult {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("popularity")
    private double mPopularity;

    @SerializedName("profile_path")
    private String mProfilePath;

    @SerializedName("known_for")
    private List<KnownFor> mKnownFor;

    @SerializedName("adult")
    private boolean mAdult;

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public String getProfilePath() {
        return mProfilePath;
    }

    public List<KnownFor> getKnownFor() {
        return mKnownFor;
    }

    public boolean isAdult() {
        return mAdult;
    }
}