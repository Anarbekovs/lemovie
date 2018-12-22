package com.lemon.lemonmovies.ui.tvshow.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.listener.OnTvShowClickListener;
import com.lemon.lemonmovies.ui.base.BaseActivity;
import com.lemon.lemonmovies.ui.tvshow.fragment.TvShowsPopularFragment;
import com.lemon.lemonmovies.ui.tvshow.fragment.TvShowsSearchFragment;

/**
 * Tv Show Search Activity contains tv show search content
 *
 * @see BaseActivity
 * @see OnTvShowClickListener
 * @see TvShowsPopularFragment
 * @see TvShowsSearchFragment
 */
public final class TvShowsSearchActivity extends BaseActivity implements OnTvShowClickListener {

    private SearchView mSearchView;

    public static Intent newIntent(final Context context) {
        return new Intent(context, TvShowsSearchActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_shows_search);
        prepareActionBar();
        if (savedInstanceState == null) {
            initUI();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(getString(R.string.app_title_search));
        if (mSearchView != null) {
            mSearchView.clearFocus();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        searchItem.expandActionView();
        mSearchView = (SearchView) searchItem.getActionView();
        mSearchView.setQueryHint(getString(R.string.hint_search));
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query != null && !query.isEmpty()) {
                    performSearch(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                getSupportFragmentManager().popBackStackImmediate(TvShowsSearchFragment.TAG,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE);
                return true;
            }
        });

        return super.onPrepareOptionsMenu(menu);
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

    private void initUI() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_tv_shows_result, TvShowsPopularFragment.newInstance(), TvShowsPopularFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    private void performSearch(final String query) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_tv_shows_result, TvShowsSearchFragment.newInstance(query), TvShowsSearchFragment.TAG)
                .addToBackStack(TvShowsSearchFragment.TAG)
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
    public void onTvShowClick(final int tvShowId) {
        getNavigator().navigateToTvShowDetailScreen(this, tvShowId);
    }
}
