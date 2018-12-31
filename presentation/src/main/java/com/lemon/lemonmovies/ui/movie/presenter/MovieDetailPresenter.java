package com.lemon.lemonmovies.ui.movie.presenter;


import android.util.Log;

import com.lemon.lemonmovies.di.scope.MoviesScope;
import com.lemon.lemonmovies.mapper.MovieDetailDataModelMapper;
import com.lemon.lemonmovies.model.detail.MovieDetailDataModel;
import com.lemon.lemonmovies.ui.base.BasePresenter;
import com.lemon.lemonmovies.ui.movie.view.MovieDetailView;
import com.lemon.domain.types.MovieType;
import com.lemon.domain.usecase.movie.AddMovieUseCase;
import com.lemon.domain.usecase.movie.DeleteMovieUseCase;
import com.lemon.domain.usecase.movie.GetMovieDetailsUseCase;
import com.lemon.domain.usecase.movie.SetMovieRatingUseCase;


import java.io.PrintStream;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@MoviesScope
public final class MovieDetailPresenter extends BasePresenter<MovieDetailView> {

    private final GetMovieDetailsUseCase mGetMovieDetailsUseCase;
    private final SetMovieRatingUseCase mSetMovieRatingUseCase;
    private final AddMovieUseCase mAddMovieUseCase;
    private final DeleteMovieUseCase mDeleteMovieUseCase;
    private int randomMovieId;

    @Inject
    public MovieDetailPresenter(final GetMovieDetailsUseCase getMovieDetailsUseCase,
                                final SetMovieRatingUseCase setMovieRatingUseCase,
                                final AddMovieUseCase addMovieUseCase,
                                final DeleteMovieUseCase deleteMovieUseCase) {
        this.mGetMovieDetailsUseCase = getMovieDetailsUseCase;
        this.mSetMovieRatingUseCase = setMovieRatingUseCase;
        this.mAddMovieUseCase = addMovieUseCase;
        this.mDeleteMovieUseCase = deleteMovieUseCase;
    }

    public void getMovieDetails(final int movieId) {
        addDisposable(mGetMovieDetailsUseCase.execute(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(MovieDetailDataModelMapper::transform)
                .subscribe(this::setMovieDetails, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                throwable.getLocalizedMessage();
                                throwable.printStackTrace();

                                Log.d("TAG","324315435435",throwable);
                            }
                        }));

        //showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void getRandomMovieDetails() {
        addDisposable(mGetMovieDetailsUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(MovieDetailDataModelMapper::transform)
                .doOnNext(movieDetailDataModel -> randomMovieId = movieDetailDataModel.getMovieId())
                .subscribe(this::setMovieDetails,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void setMovieRating(final int movieId, final double rating) {
        addDisposable(mSetMovieRatingUseCase.execute(movieId, rating));
    }

    public void addToWatchlist(final int movieId) {
        addDisposable(mAddMovieUseCase.execute(movieId, MovieType.WATCHLIST));
        mView.setWatchlistStatus(true);
    }

    public void addToWatchlist() {
        addDisposable(mAddMovieUseCase.execute(randomMovieId, MovieType.WATCHLIST));
        mView.setWatchlistStatus(true);
    }

    public void deleteFromWatchlist(final int movieId) {
        addDisposable(mDeleteMovieUseCase.execute(movieId, MovieType.WATCHLIST));
        mView.setWatchlistStatus(false);
    }

    public void deleteFromWatchlist() {
        addDisposable(mDeleteMovieUseCase.execute(randomMovieId, MovieType.WATCHLIST));
        mView.setWatchlistStatus(false);
    }

    public void addToFavorites(final int movieId) {
        addDisposable(mAddMovieUseCase.execute(movieId, MovieType.FAVORITE));
        mView.setFavoriteStatus(true);
    }

    public void addToFavorites() {
        addDisposable(mAddMovieUseCase.execute(randomMovieId, MovieType.FAVORITE));
        mView.setFavoriteStatus(true);
    }

    public void deleteFromFavorites(final int movieId) {
        addDisposable(mDeleteMovieUseCase.execute(movieId, MovieType.FAVORITE));
        mView.setFavoriteStatus(false);
    }

    public void deleteFromFavorites() {
        addDisposable(mDeleteMovieUseCase.execute(randomMovieId, MovieType.FAVORITE));
        mView.setFavoriteStatus(false);
    }

    private void setMovieDetails(final MovieDetailDataModel movie) {
        if (movie != null) {
            Timber.i("Movie /" + movie.getMovieTitle() + "/ details loaded successful");
            mView.setMovieDetails(movie);
        } else {
            Timber.w("Movie details load failed: null object");
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Movie details load error: %s", message);
    }

}
