package com.lemon.data.local.entity.credits;

/**
 * A class that represents Movie Credit which stores a simple movie information about Person character.
 */
public final class MovieCredit {

    private final int mId;
    private final String mTitle;
    private final String mCharacter;
    private final String mPoster;

    public MovieCredit(int id, String title, String character, String poster) {
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
