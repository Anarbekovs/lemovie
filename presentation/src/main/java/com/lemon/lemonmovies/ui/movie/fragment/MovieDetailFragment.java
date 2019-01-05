package com.lemon.lemonmovies.ui.movie.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.lemon.lemonmovies.BuildConfig;
import com.lemon.lemonmovies.LemonMoviesApp;
import com.lemon.lemonmovies.LemonMoviesGlideModule;
import com.lemon.lemonmovies.GlideApp;
import com.lemon.lemonmovies.LinearSpacingItemDecoration;
import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.YouTubeConfig;
import com.lemon.lemonmovies.listener.OnPersonClickListener;
import com.lemon.lemonmovies.model.detail.MovieDetailDataModel;
import com.lemon.lemonmovies.ui.base.BaseFragment;
import com.lemon.lemonmovies.ui.movie.presenter.MovieDetailPresenter;
import com.lemon.lemonmovies.ui.movie.view.MovieDetailView;
import com.lemon.lemonmovies.ui.person.adapter.PersonCreditsAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import butterknife.Optional;
import timber.log.Timber;

public final class MovieDetailFragment extends BaseFragment implements MovieDetailView {

    public static final String TAG = MovieDetailFragment.class.getSimpleName();
    private static final String ARG_MOVIE_ID = BuildConfig.APPLICATION_ID + "ARG.MOVIE_ID";

    @BindView(R.id.detail_movie_poster)
    ImageView mMoviePoster;
    @BindView(R.id.detail_movie_title)
    TextView mMovieTitle;
    @BindView(R.id.detail_movie_release_date)
    TextView mMovieReleaseDate;
    @BindView(R.id.detail_movie_tagline)
    TextView mMovieTagLine;
    @BindView(R.id.detail_movie_info)
    TextView mMovieInfo;
    @BindView(R.id.detail_movie_budget)
    TextView mMovieBudget;
    @BindView(R.id.detail_movie_revenue)
    TextView mMovieRevenue;
    @BindView(R.id.detail_movie_rating)
    TextView mMovieRating;
    @BindView(R.id.detail_movie_tmdb_rating)
    TextView mMovieTmdbRating;
    @BindView(R.id.detail_movie_overview)
    TextView mMovieOverview;
    @BindView(R.id.detail_movie_overview_title)
    TextView mMovieOverviewTitle;
    @Nullable
    @BindView(R.id.detail_movie_crew_title)
    TextView mMovieCrewTitle;
    @Nullable
    @BindView(R.id.detail_movie_cast_title)
    TextView mMovieCastTitle;

    @BindViews({R.id.detail_movie_genre_one, R.id.detail_movie_genre_two, R.id.detail_movie_genre_three,
            R.id.detail_movie_genre_four})
    List<TextView> mMovieGenres;

    @Nullable
    @BindView(R.id.detail_movie_watchlist_btn)
    ImageView mMovieWatchlistBtn;
    @Nullable
    @BindView(R.id.detail_movie_favorite_btn)
    ImageView mMovieFavoriteBtn;
    @Nullable
    @BindView(R.id.rv_detail_movie_crew)
    RecyclerView mCrewRecyclerView;
    @Nullable
    @BindView(R.id.rv_detail_movie_cast)
    RecyclerView mCastRecyclerView;

    @Inject
    MovieDetailPresenter mPresenter;

    private PersonCreditsAdapter mDirectorCreditsAdapter;
    private PersonCreditsAdapter mCastCreditsAdapter;
    private OnPersonClickListener mPersonClickListener;
    private YouTubePlayerSupportFragment mYouTubePlayerFragment;
    private YouTubePlayer mYouTubePlayer;

    private String mYoutubeKey;
    private int mMovieId;
    private boolean mWatchlist, mFavorite;
    private MovieDetailDataModel mMovie;


    public static Fragment newInstance(final int movieId) {
        final MovieDetailFragment fragment = new MovieDetailFragment();
        final Bundle args = new Bundle();
        args.putInt(ARG_MOVIE_ID, movieId);
        fragment.setArguments(args);
        return fragment;
    }

    public static Fragment newInstance() {
        return new MovieDetailFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initOnPersonClickListener(context);
        ((LemonMoviesApp) context.getApplicationContext()).getAppComponent()
                .getMoviesSubComponent().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (getArguments() != null) {
            mMovieId = getArguments().getInt(ARG_MOVIE_ID);
        }
        getMovieDetails();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mMovie != null) {
            setMovieDetails(mMovie);
        }
        mPresenter.attachView(this);
        initAdapters();
        prepareRecyclerViews();

    }


    private void initOnPersonClickListener(final Context context) {
        if (context instanceof OnPersonClickListener) {
            this.mPersonClickListener = (OnPersonClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
    }

    private void initAdapters() {
        mDirectorCreditsAdapter = new PersonCreditsAdapter(mPersonClickListener);
        mCastCreditsAdapter = new PersonCreditsAdapter(mPersonClickListener);
    }

    private void prepareRecyclerViews() {
        if (mCrewRecyclerView != null) {
            mCrewRecyclerView.setAdapter(mDirectorCreditsAdapter);
            mCrewRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL, false));
            mCrewRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                    .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_half))
                    .setOrientation(LinearLayoutManager.HORIZONTAL)
                    .includeEdge(false)
                    .build());
        }
        if (mCastRecyclerView != null) {
            mCastRecyclerView.setAdapter(mCastCreditsAdapter);

            mCastRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.HORIZONTAL, false));
            mCastRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                    .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_half))
                    .setOrientation(LinearLayoutManager.HORIZONTAL)
                    .includeEdge(false)
                    .build());
        }
    }

    private void getMovieDetails() {
        if (mMovieId != 0) {
            mPresenter.getMovieDetails(mMovieId);
        } else
            mPresenter.getRandomMovieDetails();
    }

    @Override
    public void setMovieDetails(final MovieDetailDataModel movie) {
        mMovie = movie;
        mYoutubeKey = movie.getYoutubeKey();
        if (mYoutubeKey != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            mYouTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
            childFragmentManager.beginTransaction()
                    .replace(R.id.youtube_player_fragment_frame, mYouTubePlayerFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null)
                    .commit();
            mYouTubePlayerFragment.initialize(YouTubeConfig.getApiKey(), new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
                    FloatingActionButton fab1 = (getActivity()).findViewById(R.id.fab_swap_movie);
                    FloatingActionButton fab2 = getActivity().findViewById(R.id.fab_find_movie);
                    mYouTubePlayer = youTubePlayer;
                    mYouTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
                    if (!wasRestored) {
                        mYouTubePlayer.cueVideo(mYoutubeKey);
                    }
                    mYouTubePlayer.setPlaybackEventListener(new YouTubePlayer.PlaybackEventListener() {
                        @Override
                        public void onPlaying() {
                            if (fab1 != null) fab1.setVisibility(View.GONE);
                            if (fab2 != null) fab2.setVisibility(View.GONE);
                        }

                        @Override
                        public void onPaused() {
                            if (fab1 != null) fab1.setVisibility(View.VISIBLE);
                            if (fab2 != null) fab2.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onStopped() {
                            if (fab1 != null) fab1.setVisibility(View.VISIBLE);
                            if (fab2 != null) fab2.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onBuffering(boolean b) {

                        }

                        @Override
                        public void onSeekTo(int i) {

                        }
                    });
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    Timber.d("%s", youTubeInitializationResult);
                }
            });
        }


        this.loadMoviePoster(movie.getMoviePoster(), movie.getMoviePosterPreview(), movie.getAllMoviePosters());
        this.setMovieGenres(movie.getMovieGenres());
        this.setWatchlistStatus(movie.isMovieWatchlist());
        this.setFavoriteStatus(movie.isMovieFavorite());

        if (movie.getMovieTagLine() == null || movie.getMovieTagLine().isEmpty()) {
            mMovieTitle.setMaxLines(getResources().getInteger(R.integer.detail_title_max_lines_additional));
            mMovieTagLine.setVisibility(View.GONE);
        }

        mMovieTitle.setText(movie.getMovieTitle());
        mMovieTagLine.setText(movie.getMovieTagLine());
        mMovieReleaseDate.setText(movie.getMovieReleaseDate());
        mMovieInfo.setText(movie.getMovieInfo());
        mMovieBudget.setText(movie.getMovieBudget());
        mMovieRevenue.setText(movie.getMovieRevenue());
        mMovieRating.setText(movie.getMovieRating());
        mMovieTmdbRating.setText(movie.getMovieTmdbRating());

        if (!movie.getMovieDescription().isEmpty()) {
            mMovieOverview.setText(movie.getMovieDescription());
            mMovieOverviewTitle.setVisibility(View.VISIBLE);
        }

        if (!movie.getMovieCrew().isEmpty()) {
            mDirectorCreditsAdapter.setPersons(movie.getMovieCrew());
            if (mMovieCrewTitle != null) {
                mMovieCrewTitle.setVisibility(View.VISIBLE);
            }
        }

        if (!movie.getMovieCast().isEmpty()) {
            mCastCreditsAdapter.setPersons(movie.getMovieCast());
            if (mMovieCastTitle != null) {
                mMovieCastTitle.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void setWatchlistStatus(final boolean isWatchlist) {
        this.mWatchlist = isWatchlist;
        if (isWatchlist)
            mMovie.setMovieWatchlist(true);
        else mMovie.setMovieWatchlist(false);
        if (mMovieWatchlistBtn != null) {
            mMovieWatchlistBtn.setImageResource(isWatchlist ? R.drawable.ic_watchlist_checked_24dp
                    : R.drawable.ic_watchlist_unchecked_24dp);
        }
    }

    @Override
    public void setFavoriteStatus(final boolean isFavorite) {
        this.mFavorite = isFavorite;
        if (isFavorite)
            mMovie.setMovieFavorite(true);
        else mMovie.setMovieFavorite(false);
        if (mMovieFavoriteBtn != null) {
            mMovieFavoriteBtn.setImageResource(isFavorite ? R.drawable.ic_favorite_checked_24dp
                    : R.drawable.ic_favorite_unchecked_24dp);
        }
    }

    @Optional
    @OnClick(R.id.detail_movie_watchlist_btn)
    void onWatchlistBtnClick() {
        this.performWatchlistClick();
    }

    @Optional
    @OnClick(R.id.detail_movie_favorite_btn)
    void onFavoriteBtnClick() {
        this.performFavoriteClick();
    }

    @OnClick({R.id.detail_movie_rating_logo, R.id.detail_movie_rating})
    void onRatingClick() {
        //      this.performRatingClick();
    }

    private void performWatchlistClick() {
        if (!mWatchlist && mMovieId != 0) {
            mPresenter.addToWatchlist(mMovieId);
        } else if (!mWatchlist) {
            mPresenter.addToWatchlist(mMovie.getMovieId());
        } else if (mMovieId != 0) {
            mPresenter.deleteFromWatchlist(mMovieId);
        } else {
            mPresenter.deleteFromWatchlist(mMovie.getMovieId());
        }
    }

    private void performFavoriteClick() {
        if (!mFavorite && mMovieId != 0) {
            mPresenter.addToFavorites(mMovieId);
        } else if (!mFavorite) {
            mPresenter.addToFavorites(mMovie.getMovieId());
        } else if (mMovieId != 0) {
            mPresenter.deleteFromFavorites(mMovieId);
        } else {
            mPresenter.deleteFromFavorites(mMovie.getMovieId());
        }
    }

    private void performRatingClick() {
        final double rating = 7.0; //todo stub
        mPresenter.setMovieRating(mMovieId, rating);
    }

    private void loadMoviePoster(final String posterUrl, final String previewPosterUrl, final String posters) {
        GlideApp.with(this)
                .load(posterUrl)
                .error(R.drawable.ic_local_movies_white_240dp)
                .thumbnail(GlideApp.with(this).load(previewPosterUrl))
                .centerInside()
                .transition(DrawableTransitionOptions.withCrossFade(LemonMoviesGlideModule.CROSS_FADE_DURATION))
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(mMoviePoster);
    }

    private void setMovieGenres(final List<String> genres) {
        if (genres != null) {
            final int size = genres.size() > mMovieGenres.size() ? mMovieGenres.size() : genres.size();
            for (int i = 0; i < size; i++) {
                mMovieGenres.get(i).setText(genres.get(i));
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter.disposeAll();
        if (mYouTubePlayer != null) {
            mYouTubePlayer.release();
            mYouTubePlayer = null;
        }
        if (mYouTubePlayerFragment != null)
            mYouTubePlayerFragment = null;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPersonClickListener = null;
    }
}
