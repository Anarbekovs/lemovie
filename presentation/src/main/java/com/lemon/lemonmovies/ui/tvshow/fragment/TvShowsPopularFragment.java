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

import com.lemon.lemonmovies.LemonMoviesApp;
import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.listener.OnTvShowClickListener;
import com.lemon.lemonmovies.model.result.TvShowResultDataModel;
import com.lemon.lemonmovies.ui.base.BaseFragment;
import com.lemon.lemonmovies.ui.tvshow.adapter.TvShowsResultAdapter;
import com.lemon.lemonmovies.ui.tvshow.presenter.TvShowsPopularPresenter;
import com.lemon.lemonmovies.ui.tvshow.view.TvShowsPopularView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public final class TvShowsPopularFragment extends BaseFragment implements TvShowsPopularView {

    public static final String TAG = TvShowsPopularFragment.class.getSimpleName();

    @BindView(R.id.rv_popular_tv_shows_result)
    RecyclerView mTvShowsResultRecyclerView;

    @Inject
    TvShowsPopularPresenter mPresenter;

    private TvShowsResultAdapter mTvShowsResultAdapter;
    private OnTvShowClickListener mTvShowClickListener;

    public static Fragment newInstance() {
        final TvShowsPopularFragment fragment = new TvShowsPopularFragment();
        final Bundle args = new Bundle();
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
        return inflater.inflate(R.layout.fragment_tv_shows_popular, container, false);
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
        getPopularTvShows();
    }

    private void initOnTvShowClickListener(final Context context) {
        if (context instanceof OnTvShowClickListener) {
            this.mTvShowClickListener = (OnTvShowClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
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

    private void getPopularTvShows() {
        mPresenter.getPopularTvShows();
    }

    @Override
    public void showPopularTvShows(final List<TvShowResultDataModel> tvShows) {
        mTvShowsResultAdapter.setTvShows(tvShows);
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
