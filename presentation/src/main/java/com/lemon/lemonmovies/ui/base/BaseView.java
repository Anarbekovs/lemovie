package com.lemon.lemonmovies.ui.base;

/**
 * A BaseView interface representation
 */
public interface BaseView {

    /**
     * Shows a short toast with specified message
     *
     * @param message - a message string
     */
    void showSnackbar(final String message);

    /**
     * Shows a long toast with specified message
     *
     * @param message - a message string
     */
    void showLongSnackbar(final String message);

    /**
     * Shows a progress bar
     */
    void showProgressBar();

    /**
     * Hides a progress bar
     */
    void hideProgressBar();
}
