package com.lemon.data.remote.pojo.person.find;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class PersonFindResponse {

    @SerializedName("page")
    private int mPage;

    @SerializedName("total_pages")
    private int mTotalPages;

    @SerializedName("results")
    private List<PersonResult> mResults;

    @SerializedName("total_results")
    private int mTotalResults;

    public int getPage() {
        return mPage;
    }

    public int getTotalPages() {
        return mTotalPages;
    }

    public List<PersonResult> getResults() {
        return mResults;
    }

    public int getTotalResults() {
        return mTotalResults;
    }
}