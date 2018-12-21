package com.lemon.domain.types;

/**
 * Enum class that represents type of TvShow
 */
public enum TvShowType {
    RECENT, WATCHLIST, FAVORITE;

    private static final TvShowType mTypes[] = values();

    public static TvShowType[] getValues() {
        return mTypes;
    }
}
