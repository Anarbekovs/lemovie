package com.lemon.lemonmovies.ui.tvshow.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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

import com.lemon.domain.types.MovieType;
import com.lemon.lemonmovies.BuildConfig;
import com.lemon.lemonmovies.LemonMoviesApp;
import com.lemon.lemonmovies.LinearSpacingItemDecoration;
import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.RecyclerViewScrollListenerImpl;
import com.lemon.lemonmovies.listener.OnTvShowClickListener;
import com.lemon.lemonmovies.model.item.TvShowItemDataModel;
import com.lemon.lemonmovies.ui.base.BaseFragment;
import com.lemon.lemonmovies.ui.tvshow.adapter.TvShowsAdapter;
import com.lemon.lemonmovies.ui.tvshow.presenter.TvShowsPresenter;
import com.lemon.lemonmovies.ui.tvshow.view.TvShowsView;
import com.lemon.domain.types.TvShowType;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public final class TvShowsFragment extends BaseFragment implements TvShowsView {

    public static final String TAG = TvShowsFragment.class.getSimpleName();

    private static final String ARG_TV_SHOWS_TYPE = BuildConfig.APPLICATION_ID + "ARG.TV_SHOWS_TYPE";

    @BindView(R.id.rv_tv_shows)
    RecyclerView mTvShowsRecyclerView;
    @BindView(R.id.empty_tv_shows)
    TextView mEmptyTvShowsTextView;
    private Unbinder unbinder;


    @Inject
    TvShowsPresenter mPresenter;

    private TvShowType mType;
    private TvShowsAdapter mTvShowsAdapter;
    private OnTvShowClickListener mTvShowClickListener;

    public static Fragment newInstance(final TvShowType type) {
        final TvShowsFragment fragment = new TvShowsFragment();
        final Bundle args = new Bundle();
        args.putSerializable(TvShowsFragment.ARG_TV_SHOWS_TYPE, type);
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);

        if (getArguments() != null) {
            mType = (TvShowType) getArguments().getSerializable(TvShowsFragment.ARG_TV_SHOWS_TYPE);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv_shows, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        prepareRecyclerView();
    }

    @Override
    public void onResume() {
        super.onResume();
        getTvShows();
    }

    private void initOnTvShowClickListener(final Context context) {
        if (context instanceof OnTvShowClickListener) {
            this.mTvShowClickListener = (OnTvShowClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
    }

    private void initAdapter() {
        mTvShowsAdapter = new TvShowsAdapter(mTvShowClickListener, this::onTvShowMenuClick);
    }

    private void prepareRecyclerView() {
        final FloatingActionButton fab = Objects.requireNonNull(getActivity()).findViewById(R.id.fab_find_tv_show);
        mTvShowsRecyclerView.setAdapter(mTvShowsAdapter);
        mTvShowsRecyclerView.setWillNotDraw(false);
        mTvShowsRecyclerView.addOnScrollListener(new RecyclerViewScrollListenerImpl(fab));
        mTvShowsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        mTvShowsRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_half))
                .setOrientation(LinearLayoutManager.VERTICAL)
                .includeEdge(true)
                .build());
    }

    private void getTvShows() {
        mPresenter.getTvShows(mType);
    }

    @Override
    public void setTvShows(final List<TvShowItemDataModel> tvShows) {
        mTvShowsAdapter.setTvShows(tvShows);
    }

    @Override
    public void clearTvShows() {
        mTvShowsAdapter.clearTvShows();
    }

    @Override
    public void showEmptyText() {
        if (mEmptyTvShowsTextView.getVisibility() == View.GONE) {
            mEmptyTvShowsTextView.setVisibility(View.VISIBLE);
            switch (mType) {
                case RECENT:
                    mEmptyTvShowsTextView.setText(getString(R.string.text_empty_tv_shows_recent));
                    break;
                case WATCHLIST:
                    mEmptyTvShowsTextView.setText(getString(R.string.text_empty_tv_shows_watchlist));
                    break;
                case FAVORITE:
                    mEmptyTvShowsTextView.setText(getString(R.string.text_empty_tv_shows_favorites));
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void hideEmptyText() {
        if (mEmptyTvShowsTextView.getVisibility() == View.VISIBLE) {
            mEmptyTvShowsTextView.setVisibility(View.GONE);
        }
    }

    private void onTvShowMenuClick(final int tvShowId, final View view) {
        final Context wrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_PopupStyle);
        final PopupMenu popupMenu = new PopupMenu(wrapper, view);
        popupMenu.inflate(R.menu.menu_popup_tv_show);
        Menu menu = popupMenu.getMenu();
        if (mType == TvShowType.WATCHLIST)
            menu.findItem(R.id.menu_add_to_watchlist).setVisible(false);
        if (mType == TvShowType.FAVORITE)
            menu.findItem(R.id.menu_add_to_favorites).setVisible(false);
        popupMenu.setOnMenuItemClickListener(item -> {
            final int id = item.getItemId();
            switch (id) {
                case R.id.menu_add_to_watchlist:
                    mPresenter.addToWatchlist(tvShowId);
                    break;
                case R.id.menu_add_to_favorites:
                    mPresenter.addToFavorites(tvShowId);
                    break;
                case R.id.menu_delete:
                    mPresenter.deleteFrom(tvShowId, mType);
                    break;
            }
            return true;
        });
        popupMenu.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
