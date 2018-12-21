package com.lemon.lemonmovies.ui.movie.presenter;

import com.lemon.lemonmovies.di.scope.MoviesScope;
import com.lemon.lemonmovies.mapper.MovieResultDataModelMapper;
import com.lemon.lemonmovies.model.result.MovieResultDataModel;
import com.lemon.lemonmovies.ui.base.BasePresenter;
import com.lemon.lemonmovies.ui.movie.view.MoviesSearchView;
import com.lemon.domain.usecase.movie.SearchMoviesUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@MoviesScope
public final class MoviesSearchPresenter extends BasePresenter<MoviesSearchView> {

    private final SearchMoviesUseCase mSearchMoviesUseCase;
    private static final int mPage = 1; //todo stub

    @Inject
    public MoviesSearchPresenter(final SearchMoviesUseCase searchMoviesUseCase) {
        this.mSearchMoviesUseCase = searchMoviesUseCase;
    }

    public void searchMoviesByQuery(final String query) {
        addDisposable(mSearchMoviesUseCase.execute(query, mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(MovieResultDataModelMapper::transform)
                .subscribe(this::showMoviesSearchResult,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showMoviesSearchResult(final List<MovieResultDataModel> movies) {
        if (movies != null && !movies.isEmpty()) {
            Timber.i("Movies search successful, found: %s", movies.size());
            mView.hideEmptyText();
            mView.showMoviesSearchResult(movies);
        } else {
            Timber.w("Movies search failed: empty list");
            mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Movies search error: %s", message);
        mView.showToast(message);
    }
}
