package com.lemon.lemonmovies.ui.tvshow.activity;

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
import com.lemon.lemonmovies.ui.tvshow.fragment.TvShowDetailFragment;

/**
 * TvShow Detail Activity contains detail information about tv show
 *
 * @see BaseActivity
 * @see OnPersonClickListener
 */
public final class TvShowDetailActivity extends BaseActivity implements OnPersonClickListener {

    public static final String EXTRA_TV_SHOW_ID = BuildConfig.APPLICATION_ID + "EXTRA.TV_SHOW_ID";

    public static Intent newIntent(final Context context) {
        return new Intent(context, TvShowDetailActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_detail);
        prepareActionBar();
        if (savedInstanceState == null) {
            if (getIntent() != null) {
                initUI(getIntent().getIntExtra(EXTRA_TV_SHOW_ID, 0));
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

    private void initUI(final int tvShowId) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_tvshow_detail, TvShowDetailFragment.newInstance(tvShowId), TvShowDetailFragment.TAG)
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

