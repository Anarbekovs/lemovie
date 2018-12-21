package com.lemon.lemonmovies.ui.tvshow.fragment;

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
import android.widget.TextView;

import com.lemon.lemonmovies.BuildConfig;
import com.lemon.lemonmovies.LemonMoviesApp;
import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.listener.OnTvShowClickListener;
import com.lemon.lemonmovies.model.result.TvShowResultDataModel;
import com.lemon.lemonmovies.ui.base.BaseFragment;
import com.lemon.lemonmovies.ui.tvshow.adapter.TvShowsResultAdapter;
import com.lemon.lemonmovies.ui.tvshow.presenter.TvShowsSearchPresenter;
import com.lemon.lemonmovies.ui.tvshow.view.TvShowsSearchView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public final class TvShowsSearchFragment extends BaseFragment implements TvShowsSearchView {

    public static final String TAG = TvShowsSearchFragment.class.getSimpleName();

    private static final String ARG_TV_SHOWS_SEARCH_QUERY = BuildConfig.APPLICATION_ID + "ARG.TV_SHOWS_SEARCH_QUERY";

    @BindView(R.id.rv_search_tv_shows_result)
    RecyclerView mTvShowsResultRecyclerView;
    @BindView(R.id.search_tv_shows_empty)
    TextView mEmptySearchTextView;

    @Inject
    TvShowsSearchPresenter mPresenter;

    private TvShowsResultAdapter mTvShowsResultAdapter;
    private OnTvShowClickListener mTvShowClickListener;

    public static Fragment newInstance(final String query) {
        final TvShowsSearchFragment fragment = new TvShowsSearchFragment();
        final Bundle args = new Bundle();
        args.putString(ARG_TV_SHOWS_SEARCH_QUERY, query);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initOnTvShowClickListener(context);
        ((LemonMoviesApp) context.getApplicationContext()).getAppComponent()
                .getTvShowsSubComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv_shows_search, container, false);
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
        if (getArguments() != null) {
            performSearch(getArguments().getString(ARG_TV_SHOWS_SEARCH_QUERY));
        }
    }

    private void initOnTvShowClickListener(final Context context) {
        if (context instanceof OnTvShowClickListener) {
            this.mTvShowClickListener = (OnTvShowClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
    }

    private void performSearch(final String query) {
        mPresenter.searchTvShowsByQuery(query);
    }

    private void initAdapter() {
        mTvShowsResultAdapter = new TvShowsResultAdapter(mTvShowClickListener);
    }

    private void prepareRecyclerView() {
        mTvShowsResultRecyclerView.setAdapter(mTvShowsResultAdapter);
        mTvShowsResultRecyclerView.setWillNotDraw(false);
        mTvShowsResultRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),
                getResources().getInteger(R.integer.grid_layout_span_count)));
    }

    @Override
    public void showTvShowsSearchResult(final List<TvShowResultDataModel> tvShows) {
        mTvShowsResultAdapter.setTvShows(tvShows);
    }

    @Override
    public void showEmptyText() {
        if (mEmptySearchTextView.getVisibility() == View.GONE) {
            mEmptySearchTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideEmptyText() {
        if (mEmptySearchTextView.getVisibility() == View.VISIBLE) {
            mEmptySearchTextView.setVisibility(View.GONE);
        }
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
        mTvShowClickListener = null;
    }
}
