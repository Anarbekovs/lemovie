package com.lemon.lemonmovies.ui.movie.presenter;

import com.lemon.lemonmovies.di.scope.MoviesScope;
import com.lemon.lemonmovies.mapper.MovieResultDataModelMapper;
import com.lemon.lemonmovies.model.result.MovieResultDataModel;
import com.lemon.lemonmovies.ui.base.BasePresenter;
import com.lemon.lemonmovies.ui.movie.view.MoviesPopularView;
import com.lemon.domain.usecase.movie.GetPopularMoviesUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@MoviesScope
public final class MoviesPopularPresenter extends BasePresenter<MoviesPopularView> {

    private final GetPopularMoviesUseCase mGetPopularMoviesUseCase;
    private static final int mPage = 1; //todo random

    @Inject
    public MoviesPopularPresenter(final GetPopularMoviesUseCase getPopularMoviesUseCase) {
        this.mGetPopularMoviesUseCase = getPopularMoviesUseCase;
    }

    public void getPopularMovies() {
        addDisposable(mGetPopularMoviesUseCase.execute(mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(MovieResultDataModelMapper::transform)
                .subscribe(this::showPopularMovies,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showPopularMovies(final List<MovieResultDataModel> movies) {
        if (movies != null && !movies.isEmpty()) {
            Timber.i("Popular movies loaded successful, size: %s", movies.size());
            mView.showPopularMovies(movies);
        } else {
            Timber.w("Popular movies load failed: empty list");
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Popular movies load error: %s", message);
    }
}
