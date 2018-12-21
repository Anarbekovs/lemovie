package com.lemon.data.remote.pojo.tvshow.find;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class TvShowFindResponse {

    @SerializedName("page")
    private int mPage;

    @SerializedName("total_pages")
    private int mTotalPages;

    @SerializedName("results")
    private List<TvShowResult> mResults;

    @SerializedName("total_results")
    private int mTotalResults;

    public int getPage() {
        return mPage;
    }

    public int getTotalPages() {
        return mTotalPages;
    }

    public List<TvShowResult> getResults() {
        return mResults;
    }

    public int getTotalResults() {
        return mTotalResults;
    }
}