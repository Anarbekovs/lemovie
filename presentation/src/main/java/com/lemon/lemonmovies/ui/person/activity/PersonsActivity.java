package com.lemon.lemonmovies.ui.person.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.listener.OnMovieClickListener;
import com.lemon.lemonmovies.listener.OnPersonClickListener;
import com.lemon.lemonmovies.ui.base.NavigationBaseActivity;
import com.lemon.lemonmovies.ui.person.fragment.PersonsFragment;
import com.lemon.lemonmovies.ui.person.fragment.PersonsPopularFragment;

import butterknife.BindView;

/**
 * Persons Activity contains person collections
 *
 * @see NavigationBaseActivity
 * @see OnPersonClickListener
 * @see PersonsFragment
 */
public final class PersonsActivity extends NavigationBaseActivity implements OnPersonClickListener, OnMovieClickListener {

    @BindView(R.id.fab_find_person)
    FloatingActionButton mFloatingButtonFindPerson;

    public static Intent newIntent(final Context context) {
        return new Intent(context, PersonsActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);
        super.setupDrawer();
        setFabListener();

        if (savedInstanceState == null) {
            initUI();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.app_title_person);
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
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame_persons, PersonsPopularFragment.newInstance(), PersonsPopularFragment.TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    private void setFabListener() {
        mFloatingButtonFindPerson.setOnClickListener(v -> getNavigator().navigateToPersonSearchScreen(this));
    }

    @Override
    public void onPersonClick(int personId) {
        getNavigator().navigateToPersonDetailScreen(this, personId);
    }

    @Override
    public void onMovieClick(int movieId) {
        getNavigator().navigateToMovieDetailScreen(this, movieId);
    }
}

