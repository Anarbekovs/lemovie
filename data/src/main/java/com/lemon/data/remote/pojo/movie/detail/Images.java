package com.lemon.data.remote.pojo.movie.detail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class Images {

    @SerializedName("posters")
    private List<Poster> mPosters;

    public List<Poster> getPosters() {
        return mPosters;
    }
}