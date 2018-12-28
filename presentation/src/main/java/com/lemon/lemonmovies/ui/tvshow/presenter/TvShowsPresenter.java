package com.lemon.lemonmovies.ui.tvshow.presenter;

import com.lemon.lemonmovies.di.scope.TvShowsScope;
import com.lemon.lemonmovies.mapper.TvShowItemDataModelMapper;
import com.lemon.lemonmovies.model.item.TvShowItemDataModel;
import com.lemon.lemonmovies.ui.base.BasePresenter;
import com.lemon.lemonmovies.ui.tvshow.view.TvShowsView;
import com.lemon.domain.types.TvShowType;
import com.lemon.domain.usecase.tvshow.AddTvShowUseCase;
import com.lemon.domain.usecase.tvshow.DeleteTvShowUseCase;
import com.lemon.domain.usecase.tvshow.GetTvShowsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@TvShowsScope
public final class TvShowsPresenter extends BasePresenter<TvShowsView> {

    private final GetTvShowsUseCase mGetTvShowsUseCase;
    private final AddTvShowUseCase mAddTvShowUseCase;
    private final DeleteTvShowUseCase mDeleteTvShowUseCase;

    @Inject
    public TvShowsPresenter(final GetTvShowsUseCase getTvShowsUseCase, final AddTvShowUseCase addTvShowUseCase,
                            final DeleteTvShowUseCase deleteTvShowUseCase) {
        this.mGetTvShowsUseCase = getTvShowsUseCase;
        this.mAddTvShowUseCase = addTvShowUseCase;
        this.mDeleteTvShowUseCase = deleteTvShowUseCase;
    }

    public void getTvShows(final TvShowType type) {
        addDisposable(mGetTvShowsUseCase.execute(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(TvShowItemDataModelMapper::transform)
                .subscribe(this::setTvShows,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    public void addToWatchlist(final int movieId) {
        addDisposable(mAddTvShowUseCase.execute(movieId, TvShowType.WATCHLIST));
    }

    public void addToFavorites(final int movieId) {
        addDisposable(mAddTvShowUseCase.execute(movieId, TvShowType.FAVORITE));
    }

    public void deleteFrom(final int movieId, final TvShowType type) {
        addDisposable(mDeleteTvShowUseCase.execute(movieId, type));
    }

    private void setTvShows(final List<TvShowItemDataModel> tvShows) {
        if (tvShows != null && !tvShows.isEmpty()) {
            Timber.i("TV shows loaded successful, size: %s", tvShows.size());
            mView.hideEmptyText();
            mView.setTvShows(tvShows);
        } else {
            Timber.w("TV shows load failed: empty list");
            mView.clearTvShows();
            mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("TV shows load error: %s", message);
        mView.showSnackbar(message);
    }
}
