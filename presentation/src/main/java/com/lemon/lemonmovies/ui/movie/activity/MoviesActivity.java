package com.lemon.lemonmovies.ui.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.listener.OnMovieClickListener;
import com.lemon.lemonmovies.ui.base.NavigationBaseActivity;
import com.lemon.lemonmovies.ui.movie.adapter.MoviesPagerAdapter;
import com.lemon.lemonmovies.ui.movie.fragment.MoviesFragment;

import butterknife.BindView;

/**
 * Movies Activity contains movie collections
 *
 * @see NavigationBaseActivity
 * @see OnMovieClickListener
 * @see MoviesFragment
 */
public final class MoviesActivity extends NavigationBaseActivity implements OnMovieClickListener {

    @BindView(R.id.view_pager)
    ViewPager mMoviesViewPager;
    @BindView(R.id.tab_layout)
    TabLayout mMoviesTabLayout;
    @BindView(R.id.fab_find_movie)
    FloatingActionButton mFloatingButtonFindMovie;

    private static final int OFFSCREEN_PAGE_LIMIT = 2;

    public static Intent newIntent(final Context context) {
        return new Intent(context, MoviesActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        super.setupDrawer();
        initViewPager();
        setFabListener();
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

    private void initViewPager() {
        mMoviesViewPager.setAdapter(new MoviesPagerAdapter(getSupportFragmentManager(),
                getResources().getStringArray(R.array.movies_sections)));
        mMoviesViewPager.setOffscreenPageLimit(OFFSCREEN_PAGE_LIMIT);
        mMoviesTabLayout.setupWithViewPager(mMoviesViewPager);
    }

    private void setFabListener() {
        mFloatingButtonFindMovie.setOnClickListener(v -> getNavigator().navigateToMovieSearchScreen(this));
    }

    @Override
    public void onMovieClick(int movieId) {
        getNavigator().navigateToMovieDetailScreen(this, movieId);
    }
}
