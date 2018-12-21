package com.lemon.data.local.entity.credits;

/**
 * A class that represents TvShow Credit which stores a simple tv show information about Person character.
 */
public final class TvShowCredit {

    private final int mId;
    private final String mTitle;
    private final String mCharacter;
    private final String mPoster;

    public TvShowCredit(int id, String title, String character, String poster) {
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
