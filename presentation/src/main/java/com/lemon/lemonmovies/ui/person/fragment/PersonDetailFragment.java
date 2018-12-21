package com.lemon.lemonmovies.ui.person.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.lemon.lemonmovies.BuildConfig;
import com.lemon.lemonmovies.LemonMoviesApp;
import com.lemon.lemonmovies.CatchMovieGlideModule;
import com.lemon.lemonmovies.GlideApp;
import com.lemon.lemonmovies.LinearSpacingItemDecoration;
import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.listener.OnMovieClickListener;
import com.lemon.lemonmovies.listener.OnTvShowClickListener;
import com.lemon.lemonmovies.model.detail.PersonDetailDataModel;
import com.lemon.lemonmovies.ui.base.BaseFragment;
import com.lemon.lemonmovies.ui.movie.adapter.MovieCreditsAdapter;
import com.lemon.lemonmovies.ui.person.presenter.PersonDetailPresenter;
import com.lemon.lemonmovies.ui.person.view.PersonDetailView;
import com.lemon.lemonmovies.ui.tvshow.adapter.TvShowCreditsAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public final class PersonDetailFragment extends BaseFragment implements PersonDetailView {

    public static final String TAG = PersonDetailFragment.class.getSimpleName();

    private static final String ARG_PERSON_ID = BuildConfig.APPLICATION_ID + "ARG.PERSON_ID";

    @BindView(R.id.detail_person_photo)
    ImageView mPersonPhoto;
    @BindView(R.id.detail_person_name)
    TextView mPersonName;
    @BindView(R.id.detail_person_birthday)
    TextView mPersonBirthday;
    @BindView(R.id.detail_person_deathday_title)
    TextView mPersonDeathdayTitle;
    @BindView(R.id.detail_person_deathday)
    TextView mPersonDeathday;
    @BindView(R.id.detail_person_known_as)
    TextView mPersonKnownAs;
    @BindView(R.id.detail_person_biography)
    TextView mPersonBiography;

    @BindView(R.id.detail_person_biography_title)
    TextView mPersonBiographyTitle;
    @BindView(R.id.detail_person_filmography_title)
    TextView mPersonFilmographyTitle;
    @BindView(R.id.detail_person_movies_subtitle)
    TextView mPersonMoviesSubTitle;
    @BindView(R.id.detail_person_tv_shows_subtitle)
    TextView mPersonTvShowsSubTitle;

    @BindView(R.id.detail_person_favorite_btn)
    ImageView mPersonFavoriteBtn;

    @BindView(R.id.rv_detail_movies_credits)
    RecyclerView mMovieCreditsRecyclerView;
    @BindView(R.id.rv_detail_tv_shows_credits)
    RecyclerView mTvShowCreditsRecyclerView;

    @Inject
    PersonDetailPresenter mPresenter;

    private MovieCreditsAdapter mMovieCreditsAdapter;
    private TvShowCreditsAdapter mTvShowCreditsAdapter;
    private OnMovieClickListener mMovieClickListener;
    private OnTvShowClickListener mTvShowClickListener;

    private int mPersonId;
    private boolean mFavorite;

    public static Fragment newInstance(final int personId) {
        final PersonDetailFragment fragment = new PersonDetailFragment();
        final Bundle args = new Bundle();
        args.putInt(ARG_PERSON_ID, personId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initOnMovieClickListener(context);
        initOnTvShowClickListener(context);
        ((LemonMoviesApp) context.getApplicationContext()).getAppComponent()
                .getPersonsSubComponent().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPersonId = getArguments().getInt(ARG_PERSON_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_person_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);

        initAdapters();
        prepareRecyclerViews();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mPersonId != 0) {
            getPersonDetails();
        }
    }

    private void initOnMovieClickListener(final Context context) {
        if (context instanceof OnMovieClickListener) {
            this.mMovieClickListener = (OnMovieClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
    }

    private void initOnTvShowClickListener(final Context context) {
        if (context instanceof OnTvShowClickListener) {
            this.mTvShowClickListener = (OnTvShowClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
    }

    private void initAdapters() {
        mMovieCreditsAdapter = new MovieCreditsAdapter(mMovieClickListener);
        mTvShowCreditsAdapter = new TvShowCreditsAdapter(mTvShowClickListener);
    }

    private void prepareRecyclerViews() {
        mMovieCreditsRecyclerView.setAdapter(mMovieCreditsAdapter);
        mMovieCreditsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        mMovieCreditsRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_half))
                .setOrientation(LinearLayoutManager.HORIZONTAL)
                .includeEdge(false)
                .build());

        mTvShowCreditsRecyclerView.setAdapter(mTvShowCreditsAdapter);
        mTvShowCreditsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        mTvShowCreditsRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_half))
                .setOrientation(LinearLayoutManager.HORIZONTAL)
                .includeEdge(false)
                .build());
    }

    private void getPersonDetails() {
        mPresenter.getPersonDetails(mPersonId);
    }

    @Override
    public void setPersonDetails(final PersonDetailDataModel person) {
        this.loadPersonPhoto(person.getPersonPhoto(), person.getPersonPhotoPreview());
        this.setFavoriteStatus(person.isPersonFavorite());
        mPersonName.setText(person.getPersonName());
        mPersonBirthday.setText(person.getPersonBirthday());
        mPersonKnownAs.setText(person.getPersonKnownAs());
        mPersonBiography.setText(person.getPersonBiography());

        if (person.getPersonDeathday() != null) {
            mPersonDeathday.setText(person.getPersonDeathday());
            mPersonDeathdayTitle.setVisibility(View.VISIBLE);
            mPersonDeathday.setVisibility(View.VISIBLE);
        }

        if (person.getPersonBiography() != null && !person.getPersonBiography().isEmpty()) {
            mPersonBiography.setText(person.getPersonBiography());
            mPersonBiographyTitle.setVisibility(View.VISIBLE);
        }

        if (!person.getPersonMoviesList().isEmpty()) {
            mMovieCreditsAdapter.setMovies(person.getPersonMoviesList());
            mPersonFilmographyTitle.setVisibility(View.VISIBLE);
            mPersonMoviesSubTitle.setVisibility(View.VISIBLE);
        }

        if (!person.getPersonTvShowsList().isEmpty()) {
            mTvShowCreditsAdapter.setTvShows(person.getPersonTvShowsList());
            mPersonFilmographyTitle.setVisibility(View.VISIBLE);
            mPersonTvShowsSubTitle.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setFavoriteStatus(final boolean isFavorite) {
        this.mFavorite = isFavorite;
        mPersonFavoriteBtn.setImageResource(isFavorite ? R.drawable.ic_favorite_checked_24dp
                : R.drawable.ic_favorite_unchecked_24dp);
    }

    @OnClick(R.id.detail_person_favorite_btn)
    void onWatchlistBtnClick() {
        this.performFavoriteClick();
    }

    private void performFavoriteClick() {
        if (!mFavorite) {
            mPresenter.addToFavorites(mPersonId);
        } else {
            mPresenter.deleteFromFavorites(mPersonId);
        }
    }

    private void loadPersonPhoto(final String posterUrl, final String previewPosterUrl) {
        GlideApp.with(this)
                .load(posterUrl)
                .thumbnail(GlideApp.with(this).load(previewPosterUrl))
                .centerInside()
                .transition(DrawableTransitionOptions.withCrossFade(CatchMovieGlideModule.CROSS_FADE_DURATION))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(mPersonPhoto);
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
        mTvShowClickListener = null;
    }
}
