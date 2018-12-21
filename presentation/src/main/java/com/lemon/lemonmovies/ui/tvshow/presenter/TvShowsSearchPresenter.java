package com.lemon.lemonmovies.ui.tvshow.presenter;

import com.lemon.lemonmovies.di.scope.TvShowsScope;
import com.lemon.lemonmovies.mapper.TvShowResultDataModelMapper;
import com.lemon.lemonmovies.model.result.TvShowResultDataModel;
import com.lemon.lemonmovies.ui.base.BasePresenter;
import com.lemon.lemonmovies.ui.tvshow.view.TvShowsSearchView;
import com.lemon.domain.usecase.tvshow.SearchTvShowsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@TvShowsScope
public final class TvShowsSearchPresenter extends BasePresenter<TvShowsSearchView> {

    private final SearchTvShowsUseCase mSearchTvShowsUseCase;
    private static final int mPage = 1; //todo stub

    @Inject
    public TvShowsSearchPresenter(final SearchTvShowsUseCase searchTvShowsUseCase) {
        this.mSearchTvShowsUseCase = searchTvShowsUseCase;
    }

    public void searchTvShowsByQuery(final String query) {
        addDisposable(mSearchTvShowsUseCase.execute(query, mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(TvShowResultDataModelMapper::transform)
                .subscribe(this::showTvShowsSearchResult,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showTvShowsSearchResult(final List<TvShowResultDataModel> tvShows) {
        if (tvShows != null && !tvShows.isEmpty()) {
            Timber.i("TV search successful, found: %s", tvShows.size());
            mView.hideEmptyText();
            mView.showTvShowsSearchResult(tvShows);
        } else {
            Timber.w("TV search failed: empty list");
            mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("TV search error: %s", message);
        mView.showToast(message);
    }
}
