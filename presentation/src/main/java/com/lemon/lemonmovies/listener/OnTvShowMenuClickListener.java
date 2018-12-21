package com.lemon.lemonmovies.listener;

import android.view.View;

/**
 * A simple ClickListener interface
 */
public interface OnTvShowMenuClickListener {

    /**
     * Performs on tv show item context menu click
     *
     * @param tvShowId - a tv show id
     * @param view     - a view that was clicked
     */
    void onTvShowMenuClick(final int tvShowId, final View view);
}
