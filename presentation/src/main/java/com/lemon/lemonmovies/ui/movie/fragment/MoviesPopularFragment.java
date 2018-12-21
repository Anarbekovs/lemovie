package com.lemon.lemonmovies.ui.movie.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lemon.lemonmovies.LemonMoviesApp;
import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.listener.OnMovieClickListener;
import com.lemon.lemonmovies.model.result.MovieResultDataModel;
import com.lemon.lemonmovies.ui.base.BaseFragment;
import com.lemon.lemonmovies.ui.movie.adapter.MoviesResultAdapter;
import com.lemon.lemonmovies.ui.movie.presenter.MoviesPopularPresenter;
import com.lemon.lemonmovies.ui.movie.view.MoviesPopularView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public final class MoviesPopularFragment extends BaseFragment implements MoviesPopularView {

    public static final String TAG = MoviesPopularFragment.class.getSimpleName();

    @BindView(R.id.rv_popular_movies_result)
    RecyclerView mMoviesResultRecyclerView;

    @Inject
    MoviesPopularPresenter mPresenter;

    private MoviesResultAdapter mMoviesResultAdapter;
    private OnMovieClickListener mMovieClickListener;

    public static Fragment newInstance() {
        final MoviesPopularFragment fragment = new MoviesPopularFragment();
        final Bundle args = new Bundle();
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies_popular, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);

        initAdapter();
        prepareRecyclerView();
    }

    @Override
    public void onStart() {
        super.onStart();
        getPopularMovies();
    }

    private void initOnMovieClickListener(final Context context) {
        if (context instanceof OnMovieClickListener) {
            this.mMovieClickListener = (OnMovieClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
    }

    private void initAdapter() {
        mMoviesResultAdapter = new MoviesResultAdapter(mMovieClickListener);
    }

    private void prepareRecyclerView() {
        mMoviesResultRecyclerView.setAdapter(mMoviesResultAdapter);
        mMoviesResultRecyclerView.setWillNotDraw(false);
        mMoviesResultRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),
                getResources().getInteger(R.integer.grid_layout_span_count)));
    }

    private void getPopularMovies() {
        mPresenter.getPopularMovies();
    }

    @Override
    public void showPopularMovies(final List<MovieResultDataModel> movies) {
        mMoviesResultAdapter.setMovies(movies);
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
