package com.lemon.lemonmovies.ui.movie.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lemon.lemonmovies.ui.movie.fragment.MoviesFragment;
import com.lemon.domain.types.MovieType;

public final class MoviesPagerAdapter extends FragmentStatePagerAdapter {

    private final String[] mMoviesSections;

    public MoviesPagerAdapter(final FragmentManager fragmentManager, final String[] sections) {
        super(fragmentManager);
        this.mMoviesSections = sections;
    }

    @Override
    public Fragment getItem(final int position) {
        return MoviesFragment.newInstance(MovieType.getValues()[position]);
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        return mMoviesSections[position];
    }

    @Override
    public int getCount() {
        return mMoviesSections.length;
    }


}