package com.lemon.lemonmovies.navigation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.ui.movie.activity.MovieDetailActivity;
import com.lemon.lemonmovies.ui.movie.activity.MoviesActivity;
import com.lemon.lemonmovies.ui.movie.activity.MoviesSearchActivity;
import com.lemon.lemonmovies.ui.person.activity.PersonDetailActivity;
import com.lemon.lemonmovies.ui.person.activity.PersonsActivity;
import com.lemon.lemonmovies.ui.person.activity.PersonsSearchActivity;
import com.lemon.lemonmovies.ui.settings.SettingsStubActivity;
import com.lemon.lemonmovies.ui.tvshow.activity.TvShowDetailActivity;
import com.lemon.lemonmovies.ui.tvshow.activity.TvShowsActivity;
import com.lemon.lemonmovies.ui.tvshow.activity.TvShowsSearchActivity;

/**
 * A simple Navigator class to navigate through app screens
 */
public final class Navigator {

    /**
     * Navigates to Movies Collections Screen
     *
     * @param context - a calling component context
     * @see MoviesActivity
     */
    public void navigateToMoviesScreen(@NonNull final Context context) {
        final Intent moviesIntent = MoviesActivity.newIntent(context);
        context.startActivity(moviesIntent);
    }

    /**
     * Navigates to Tv Shows Collections Screen
     *
     * @param context - a calling component context
     * @see TvShowsActivity
     */
    public void navigateToTvShowsScreen(@NonNull final Context context) {
        final Intent tvShowsIntent = TvShowsActivity.newIntent(context);
        context.startActivity(tvShowsIntent);
    }

    /**
     * Navigates to Persons Collection Screen
     *
     * @param context - a calling component context
     * @see PersonsActivity
     */
    public void navigateToPersonsScreen(@NonNull final Context context) {
        final Intent personsIntent = PersonsActivity.newIntent(context);
        context.startActivity(personsIntent);
    }

    /**
     * Navigates to Movie Detail Screen
     *
     * @param context - a calling component context
     * @see MovieDetailActivity
     */
    public void navigateToMovieDetailScreen(@NonNull final Context context, final int movieId) {
        final Intent movieDetailIntent = MovieDetailActivity.newIntent(context);
        movieDetailIntent.putExtra(MovieDetailActivity.EXTRA_MOVIE_ID, movieId);
        context.startActivity(movieDetailIntent);
    }

    /**
     * Navigates to Tv Show Detail Screen
     *
     * @param context - a calling component context
     * @see TvShowDetailActivity
     */
    public void navigateToTvShowDetailScreen(@NonNull final Context context, final int tvShowId) {
        final Intent tvShowDetailIntent = TvShowDetailActivity.newIntent(context);
        tvShowDetailIntent.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW_ID, tvShowId);
        context.startActivity(tvShowDetailIntent);
    }

    /**
     * Navigates to Person Detail Screen
     *
     * @param context - a calling component context
     * @see PersonDetailActivity
     */
    public void navigateToPersonDetailScreen(@NonNull final Context context, final int personId) {
        final Intent personDetailIntent = PersonDetailActivity.newIntent(context);
        personDetailIntent.putExtra(PersonDetailActivity.EXTRA_PERSON_ID, personId);
        context.startActivity(personDetailIntent);
    }

    /**
     * Navigates to Settings Screen
     *
     * @param context - a calling component context
     * @see SettingsStubActivity
     */
    public void navigateToSettingsScreen(@NonNull final Context context) {
        final Intent settingsIntent = SettingsStubActivity.newIntent(context);
        context.startActivity(settingsIntent);
    }

    /**
     * Navigates to Movie Search Screen
     *
     * @param context - a calling component context
     * @see MoviesSearchActivity
     */
    public void navigateToMovieSearchScreen(@NonNull final Context context) {
        final Intent movieSearchIntent = MoviesSearchActivity.newIntent(context);
        context.startActivity(movieSearchIntent);
    }

    /**
     * Navigates to Tv Show Search Screen
     *
     * @param context - a calling component context
     * @see TvShowsSearchActivity
     */
    public void navigateToTvShowSearchScreen(@NonNull final Context context) {
        final Intent tvShowSearchIntent = TvShowsSearchActivity.newIntent(context);
        context.startActivity(tvShowSearchIntent);
    }

    /**
     * Navigates to Persons Search Screen
     *
     * @param context - a calling component context
     * @see PersonsSearchActivity
     */
    public void navigateToPersonSearchScreen(@NonNull final Context context) {
        final Intent personSearchIntent = PersonsSearchActivity.newIntent(context);
        context.startActivity(personSearchIntent);
    }

    /**
     * Navigates to Contact Screen through any email app
     *
     * @param context     - a calling component context
     * @param mailSubject - a mail subject
     * @param mailBody    - a mail body
     * @param mailAddress - a mail address
     */
    public void navigateToContactScreen(@NonNull final Context context, final String mailSubject,
                                        final String mailBody, final String mailAddress) {
        final Intent sendToIntent = new Intent(Intent.ACTION_SENDTO);
        final String uriString = "mailto:" + Uri.encode(mailAddress) +
                "?subject=" + Uri.encode(mailSubject) + "&body=" + Uri.encode(mailBody);
        sendToIntent.setData(Uri.parse(uriString));
        context.startActivity(Intent.createChooser(sendToIntent,
                context.getString(R.string.mail_chooser_text)));
    }


    /**
     * Navigates to Market App Screen
     *
     * @param context - a calling component context
     */
    public void navigateToMarketAppRating(@NonNull final Context context) {
        final String appPackageName = "com.lemon.lemonmovies";
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }


}
