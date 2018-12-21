package com.lemon.domain.usecase.tvshow;

import com.lemon.domain.repository.TvShowsRepository;
import com.lemon.domain.types.TvShowType;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * A UseCase class for adding tv show to collection
 */
public final class AddTvShowUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public AddTvShowUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Disposable execute(final int tvShowId, final TvShowType type) {
        switch (type) {
            case WATCHLIST:
                return mTvShowsRepository.addTvShowToWatchlist(tvShowId);
            case FAVORITE:
                return mTvShowsRepository.addTvShowToFavorites(tvShowId);
            default:
                return null;
        }
    }
}
