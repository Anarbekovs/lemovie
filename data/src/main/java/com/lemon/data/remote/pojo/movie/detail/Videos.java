package com.lemon.data.remote.pojo.movie.detail;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Videos {
    @SerializedName("results")
    private List<Results> mResults;

    public List<Results> getResults() {
        return mResults;
    }
}
