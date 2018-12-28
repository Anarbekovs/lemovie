package com.lemon.lemonmovies.ui.tvshow.activity;

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
import com.lemon.lemonmovies.listener.OnPersonClickListener;
import com.lemon.lemonmovies.listener.OnTvShowClickListener;
import com.lemon.lemonmovies.ui.base.NavigationBaseActivity;
import com.lemon.lemonmovies.ui.tvshow.fragment.TvShowDetailFragment;
import com.lemon.lemonmovies.ui.tvshow.fragment.TvShowsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * TvShows Activity contains tv show collections
 *
 * @see NavigationBaseActivity
 * @see OnTvShowClickListener
 * @see TvShowsFragment
 */
public final class TvShowsActivity extends NavigationBaseActivity implements OnTvShowClickListener,OnPersonClickListener {

    @BindView(R.id.fab_find_tv_show)
    FloatingActionButton mFloatingButtonFindTvShow;
    @BindView(R.id.fab_swap_tv_swows)
    FloatingActionButton mFabSwapTvSwows;


    public static Intent newIntent(final Context context) {
        return new Intent(context, TvShowsActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_shows);
        ButterKnife.bind(this);
        super.setupDrawer();
        initUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.app_title_tv_shows);
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
        Fragment fragment = fm.findFragmentById(R.id.frame_tv_shows);

        if (fragment == null) {
            fm.beginTransaction()
                    .add(R.id.frame_tv_shows, TvShowDetailFragment.newInstance(), TvShowDetailFragment.TAG)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }
    }

    @Override
    public void onTvShowClick(int tvShowId) {
        getNavigator().navigateToTvShowDetailScreen(this, tvShowId);
    }

    @Override
    public void onPersonClick(final int personId) {
        getNavigator().navigateToPersonDetailScreen(this, personId);
    }

    @OnClick({R.id.fab_find_tv_show, R.id.fab_swap_tv_swows})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab_find_tv_show:
                mFloatingButtonFindTvShow.setOnClickListener(v -> getNavigator().navigateToTvShowSearchScreen(this));
                break;
            case R.id.fab_swap_tv_swows:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_tv_shows, TvShowDetailFragment.newInstance(), TvShowDetailFragment.TAG)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
                break;
        }
    }
}
