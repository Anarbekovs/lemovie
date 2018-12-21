package com.lemon.domain.usecase.tvshow;

import com.lemon.domain.repository.TvShowsRepository;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * A UseCase class for setting tv show rating
 */
public final class SetTvShowRatingUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public SetTvShowRatingUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Disposable execute(final int tvShowId, final double rating) {
        return mTvShowsRepository.setTvShowRating(tvShowId, rating);
    }
}
