package com.lemon.lemonmovies.model.detail.credits;

/**
 * Model that represents Movie Credit in presentation-layer
 */
public final class MovieCreditDataModel {

    private final int mId;
    private final String mTitle;
    private final String mCharacter;
    private final String mPoster;

    public MovieCreditDataModel(int id, String title, String character, String poster) {
        this.mId = id;
        this.mTitle = title;
        this.mCharacter = character;
        this.mPoster = poster;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getCharacter() {
        return mCharacter;
    }

    public String getPoster() {
        return mPoster;
    }
}
