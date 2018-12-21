package com.lemon.data.remote.pojo.movie.detail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class Credits {

    @SerializedName("cast")
    private List<Cast> mCast;

    @SerializedName("crew")
    private List<Crew> mCrew;

    public List<Cast> getCast() {
        return mCast;
    }

    public List<Crew> getCrew() {
        return mCrew;
    }
}