package com.lemon.lemonmovies;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.util.Log;

import timber.log.Timber;

import static timber.log.Timber.Tree;

/**
 * Timber logging class TimberReleaseTree for release build only
 *
 * @see Timber
 * @see Tree
 */
public final class TimberReleaseTree extends Tree {

    private static final int MAX_LOG_LENGTH = 4000;

    @Override
    protected boolean isLoggable(String tag, int priority) {
        //release logs will be only with .w, .e and .wtf priority
        return (!(priority == Log.INFO || priority == Log.VERBOSE || priority == Log.DEBUG));
    }

    @SuppressLint("LogNotTimber")
    @Override
    protected void log(int priority, String tag, @NonNull String message, Throwable t) {
        if (isLoggable(tag, priority)) {
            //short log message
            if (message.length() <= MAX_LOG_LENGTH) {
                if (priority == Log.ASSERT) {
                    Log.wtf(tag, message);
                } else {
                    Log.println(priority, tag, message);
                }
                return;
            }
            //long log message, split by line
            for (int i = 0, length = message.length(); i < length; i++) {
                int newline = message.indexOf('\n', i);
                newline = newline != -1 ? newline : length;
                do {
                    int end = Math.min(newline, i + MAX_LOG_LENGTH);
                    String part = message.substring(i, end);
                    if (priority == Log.ASSERT) {
                        Log.wtf(tag, part);
                    } else {
                        Log.println(priority, tag, part);
                    }
                    i = end;
                } while (i < newline);
            }
        }
    }
}