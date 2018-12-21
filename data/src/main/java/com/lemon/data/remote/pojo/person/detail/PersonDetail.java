package com.lemon.data.remote.pojo.person.detail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class PersonDetail {

    @SerializedName("id")
    private int mId;

    @SerializedName("birthday")
    private String mBirthday;

    @SerializedName("also_known_as")
    private List<String> mAlsoKnownAs;

    @SerializedName("gender")
    private int mGender;

    @SerializedName("imdb_id")
    private String mImdbId;

    @SerializedName("known_for_department")
    private String mKnownForDepartment;

    @SerializedName("profile_path")
    private String mProfilePath;

    @SerializedName("biography")
    private String mBiography;

    @SerializedName("deathday")
    private String mDeathday;

    @SerializedName("place_of_birth")
    private String mPlaceOfBirth;

    @SerializedName("popularity")
    private double mPopularity;

    @SerializedName("name")
    private String mName;

    @SerializedName("adult")
    private boolean mAdult;

    @SerializedName("homepage")
    private String mHomepage;

    @SerializedName("tv_credits")
    private TvShowsCredits mTvShowsCredits;

    @SerializedName("movie_credits")
    private MoviesCredits mMoviesCredits;

    public int getId() {
        return mId;
    }

    public String getBirthday() {
        return mBirthday;
    }

    public List<String> getAlsoKnownAs() {
        return mAlsoKnownAs;
    }

    public int getGender() {
        return mGender;
    }

    public String getImdbId() {
        return mImdbId;
    }

    public String getKnownForDepartment() {
        return mKnownForDepartment;
    }

    public String getProfilePath() {
        return mProfilePath;
    }

    public String getBiography() {
        return mBiography;
    }

    public String getDeathday() {
        return mDeathday;
    }

    public String getPlaceOfBirth() {
        return mPlaceOfBirth;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public String getName() {
        return mName;
    }

    public boolean isAdult() {
        return mAdult;
    }

    public String getHomepage() {
        return mHomepage;
    }

    public TvShowsCredits getTvShowsCredits() {
        return mTvShowsCredits;
    }

    public MoviesCredits getMoviesCredits() {
        return mMoviesCredits;
    }
}