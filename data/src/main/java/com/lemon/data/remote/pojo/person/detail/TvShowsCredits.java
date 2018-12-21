package com.lemon.data.remote.pojo.person.detail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class TvShowsCredits {

    @SerializedName("cast")
    private List<PersonCast> mPersonCast;

    @SerializedName("crew")
    private List<PersonCrew> mPersonCrew;

    public List<PersonCast> getPersonCast() {
        return mPersonCast;
    }

    public List<PersonCrew> getPersonCrew() {
        return mPersonCrew;
    }
}