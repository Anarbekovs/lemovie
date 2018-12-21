package com.lemon.domain.usecase.tvshow;

import com.lemon.domain.repository.TvShowsRepository;
import com.lemon.domain.types.TvShowType;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * A UseCase class for deleting tv show from collection
 */
public final class DeleteTvShowUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public DeleteTvShowUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Disposable execute(final int tvShowId, final TvShowType type) {
        switch (type) {
            case RECENT:
                return mTvShowsRepository.deleteTvShowFromRecent(tvShowId);
            case WATCHLIST:
                return mTvShowsRepository.deleteTvShowFromWatchlist(tvShowId);
            case FAVORITE:
                return mTvShowsRepository.deleteTvShowFromFavorites(tvShowId);
            default:
                return null;
        }
    }
}
