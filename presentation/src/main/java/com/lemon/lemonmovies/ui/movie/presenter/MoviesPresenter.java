package com.lemon.lemonmovies.ui.movie.presenter;

import com.lemon.lemonmovies.di.scope.MoviesScope;
import com.lemon.lemonmovies.mapper.MovieItemDataModelMapper;
import com.lemon.lemonmovies.model.item.MovieItemDataModel;
import com.lemon.lemonmovies.ui.base.BasePresenter;
import com.lemon.lemonmovies.ui.movie.view.MoviesView;
import com.lemon.domain.types.MovieType;
import com.lemon.domain.usecase.movie.AddMovieUseCase;
import com.lemon.domain.usecase.movie.DeleteMovieUseCase;
import com.lemon.domain.usecase.movie.GetMoviesUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@MoviesScope
public final class MoviesPresenter extends BasePresenter<MoviesView> {

    private final GetMoviesUseCase mGetMoviesUseCase;
    private final AddMovieUseCase mAddMovieUseCase;
    private final DeleteMovieUseCase mDeleteMovieUseCase;

    @Inject
    public MoviesPresenter(final GetMoviesUseCase getMoviesUseCase, final AddMovieUseCase addMovieUseCase,
                           final DeleteMovieUseCase deleteMovieUseCase) {
        this.mGetMoviesUseCase = getMoviesUseCase;
        this.mAddMovieUseCase = addMovieUseCase;
        this.mDeleteMovieUseCase = deleteMovieUseCase;
    }

    public void getMovies(final MovieType type) {
        addDisposable(mGetMoviesUseCase.execute(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(MovieItemDataModelMapper::transform)
                .subscribe(this::setMovies,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void addToWatchlist(final int movieId) {
        addDisposable(mAddMovieUseCase.execute(movieId, MovieType.WATCHLIST));
    }

    public void addToFavorites(final int movieId) {
        addDisposable(mAddMovieUseCase.execute(movieId, MovieType.FAVORITE));
    }

    public void deleteFrom(final int movieId, final MovieType type) {
        addDisposable(mDeleteMovieUseCase.execute(movieId, type));
    }

    private void setMovies(final List<MovieItemDataModel> movies) {
        if (movies != null && !movies.isEmpty()) {
            Timber.i("Movies loaded successful, size: %s", movies.size());
            mView.hideEmptyText();
            mView.setMovies(movies);
        } else {
            Timber.w("Movies load failed: empty list");
            mView.clearMovies();
            mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Movies load error: %s", message);
        mView.showShortToast(message);
    }


}
