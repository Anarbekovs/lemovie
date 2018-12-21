package com.lemon.lemonmovies.listener;

import android.view.View;

/**
 * A simple ClickListener interface
 */
public interface OnMovieMenuClickListener {

    /**
     * Performs on movie item context menu click
     *
     * @param movieId - a movie id
     * @param view    - a view that was clicked
     */
    void onMovieMenuClick(final int movieId, final View view);
}
