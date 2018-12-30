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
    void showShortToast(final String message);

    /**
     * Shows a long toast with specified message
     *
     * @param message - a message string
     */
    void showLongToast(final String message);

    /**
     * Shows a progress bar
     */
    void showProgressBar();

    /**
     * Hides a progress bar
     */
    void hideProgressBar();
}
