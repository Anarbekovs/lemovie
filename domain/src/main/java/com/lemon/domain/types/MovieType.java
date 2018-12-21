package com.lemon.domain.types;

/**
 * Enum class that represents type of Movie
 */
public enum MovieType {
    RECENT, WATCHLIST, FAVORITE;

    private static final MovieType mTypes[] = values();

    public static MovieType[] getValues() {
        return mTypes;
    }
}
