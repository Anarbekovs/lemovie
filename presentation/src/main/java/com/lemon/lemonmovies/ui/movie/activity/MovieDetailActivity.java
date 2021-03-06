package com.lemon.lemonmovies.ui.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.lemon.lemonmovies.BuildConfig;
import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.listener.OnPersonClickListener;
import com.lemon.lemonmovies.ui.base.BaseActivity;
import com.lemon.lemonmovies.ui.movie.fragment.MovieDetailFragment;

/**
 * Movie Detail Activity contains detail information about movie
 *
 * @see BaseActivity
 * @see OnPersonClickListener
 */
public final class MovieDetailActivity extends BaseActivity implements OnPersonClickListener {

    public static final String EXTRA_MOVIE_ID = BuildConfig.APPLICATION_ID + "EXTRA.MOVIE_ID";

    public static Intent newIntent(final Context context) {
        return new Intent(context, MovieDetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        prepareActionBar();
        if (savedInstanceState == null) {
            if (getIntent() != null) {
                initUI(getIntent().getIntExtra(EXTRA_MOVIE_ID, 0));
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle("");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initUI(final int movieId) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_movie_detail, MovieDetailFragment.newInstance(movieId), MovieDetailFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    private void prepareActionBar() {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onPersonClick(final int personId) {
        getNavigator().navigateToPersonDetailScreen(this, personId);
    }
}

