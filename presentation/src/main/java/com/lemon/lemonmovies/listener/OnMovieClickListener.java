package com.lemon.lemonmovies.listener;

/**
 * A simple ClickListener interface
 */
public interface OnMovieClickListener {

    /**
     * Performs on movie item click
     *
     * @param movieId - a movie id
     */
    void onMovieClick(final int movieId);
}
