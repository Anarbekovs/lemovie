package com.lemon.lemonmovies.ui.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.listener.OnMovieClickListener;
import com.lemon.lemonmovies.listener.OnPersonClickListener;
import com.lemon.lemonmovies.ui.base.NavigationBaseActivity;
import com.lemon.lemonmovies.ui.movie.fragment.MovieDetailFragment;
import com.lemon.lemonmovies.ui.movie.fragment.MoviesFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Movies Activity contains movie collections
 *
 * @see NavigationBaseActivity
 * @see OnMovieClickListener
 * @see MoviesFragment
 */
public final class MoviesActivity extends NavigationBaseActivity implements OnMovieClickListener, OnPersonClickListener {


    @BindView(R.id.fab_find_movie)
    FloatingActionButton mFloatingButtonFindMovie;
    @BindView(R.id.fab_swap_movie)
    FloatingActionButton mFloatingButtonSwapMovie;

    public static Intent newIntent(final Context context) {
        return new Intent(context, MoviesActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        ButterKnife.bind(this);
        super.setupDrawer();
        initUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.app_title_movies);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                getNavigator().navigateToSettingsScreen(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initUI() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(MovieDetailFragment.TAG);

        if (fragment == null) {
            fm.beginTransaction()
                    .add(R.id.frame_movie, MovieDetailFragment.newInstance(), MovieDetailFragment.TAG)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }
    }


    @Override
    public void onMovieClick(int movieId) {
        getNavigator().navigateToMovieDetailScreen(this, movieId);
    }

    @Override
    public void onPersonClick(final int personId) {
        getNavigator().navigateToPersonDetailScreen(this, personId);
    }

    @OnClick({R.id.fab_find_movie, R.id.fab_swap_movie})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab_find_movie:
                getNavigator().navigateToMovieSearchScreen(this);
                break;
            case R.id.fab_swap_movie:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_movie, MovieDetailFragment.newInstance(), MovieDetailFragment.TAG)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
                break;
        }
    }
}
