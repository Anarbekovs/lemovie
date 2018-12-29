package com.lemon.lemonmovies.ui.movie.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lemon.lemonmovies.BuildConfig;
import com.lemon.lemonmovies.LemonMoviesApp;
import com.lemon.lemonmovies.LinearSpacingItemDecoration;
import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.RecyclerViewScrollListenerImpl;
import com.lemon.lemonmovies.listener.OnMovieClickListener;
import com.lemon.lemonmovies.model.item.MovieItemDataModel;
import com.lemon.lemonmovies.ui.base.BaseFragment;
import com.lemon.lemonmovies.ui.movie.adapter.MoviesAdapter;
import com.lemon.lemonmovies.ui.movie.presenter.MoviesPresenter;
import com.lemon.lemonmovies.ui.movie.view.MoviesView;
import com.lemon.domain.types.MovieType;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;

public final class MoviesFragment extends BaseFragment implements MoviesView {

    public static final String TAG = MoviesFragment.class.getSimpleName();

    private static final String ARG_MOVIES_TYPE = BuildConfig.APPLICATION_ID + "ARG.MOVIES_TYPE";

    @BindView(R.id.rv_movies)
    RecyclerView mMoviesRecyclerView;
    @BindView(R.id.empty_movies)
    TextView mEmptyMoviesTextView;

    @Inject
    MoviesPresenter mPresenter;

    private MovieType mType;
    private MoviesAdapter mMoviesAdapter;
    private OnMovieClickListener mMovieClickListener;

    public static Fragment newInstance(final MovieType type) {
        final MoviesFragment fragment = new MoviesFragment();
        final Bundle args = new Bundle();
        args.putSerializable(MoviesFragment.ARG_MOVIES_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initOnMovieClickListener(context);
        ((LemonMoviesApp) context.getApplicationContext()).getAppComponent()
                .getMoviesSubComponent().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = (MovieType) getArguments().getSerializable(MoviesFragment.ARG_MOVIES_TYPE);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);

        initAdapter();
        prepareRecyclerView();
    }

    @Override
    public void onResume() {
        super.onResume();
        getMovies();
    }

    private void initOnMovieClickListener(final Context context) {
        if (context instanceof OnMovieClickListener) {
            this.mMovieClickListener = (OnMovieClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
    }

    private void initAdapter() {
        mMoviesAdapter = new MoviesAdapter(mMovieClickListener, this::onMovieMenuClick);
    }

    private void prepareRecyclerView() {
        final FloatingActionButton fab = Objects.requireNonNull(getActivity()).findViewById(R.id.fab_find_movie);
        final FloatingActionButton fab2 = Objects.requireNonNull(getActivity()).findViewById(R.id.fab_swap_movie);
        mMoviesRecyclerView.setAdapter(mMoviesAdapter);
        mMoviesRecyclerView.setWillNotDraw(false);
        mMoviesRecyclerView.addOnScrollListener(new RecyclerViewScrollListenerImpl(fab));
        mMoviesRecyclerView.addOnScrollListener(new RecyclerViewScrollListenerImpl(fab2));
        mMoviesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        mMoviesRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_half))
                .setOrientation(LinearLayoutManager.VERTICAL)
                .includeEdge(true)
                .build());
    }

    private void getMovies() {
        mPresenter.getMovies(mType);
    }

    @Override
    public void setMovies(final List<MovieItemDataModel> movies) {
        mMoviesAdapter.setMovies(movies);
    }

    @Override
    public void clearMovies() {
        mMoviesAdapter.clearMovies();
    }

    @Override
    public void showEmptyText() {
        if (mEmptyMoviesTextView.getVisibility() == View.GONE) {
            mEmptyMoviesTextView.setVisibility(View.VISIBLE);
            switch (mType) {
                case RECENT:
                    mEmptyMoviesTextView.setText(getString(R.string.text_empty_movies_recent));
                    break;
                case WATCHLIST:
                    mEmptyMoviesTextView.setText(getString(R.string.text_empty_movies_watchlist));
                    break;
                case FAVORITE:
                    mEmptyMoviesTextView.setText(getString(R.string.text_empty_movies_favorites));
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void hideEmptyText() {
        if (mEmptyMoviesTextView.getVisibility() == View.VISIBLE) {
            mEmptyMoviesTextView.setVisibility(View.GONE);
        }
    }

    private void onMovieMenuClick(final int movieId, final View view) {
        final Context wrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_PopupStyle);
        final PopupMenu popupMenu = new PopupMenu(wrapper, view);
        popupMenu.inflate(R.menu.menu_popup_movie);

        popupMenu.setOnMenuItemClickListener(item -> {
            final int id = item.getItemId();
            switch (id) {
                case R.id.menu_add_to_watchlist:
                    mPresenter.addToWatchlist(movieId);
                    break;
                case R.id.menu_add_to_favorites:
                    mPresenter.addToFavorites(movieId);
                    break;
                case R.id.menu_delete:
                    mPresenter.deleteFrom(movieId, mType);
                    break;
            }
            return true;
        });
        popupMenu.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter.disposeAll();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mMovieClickListener = null;
    }
}
