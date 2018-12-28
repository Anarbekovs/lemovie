package com.lemon.domain.usecase.tvshow;

import com.lemon.domain.model.detail.MovieDetailModel;
import com.lemon.domain.model.detail.TvShowDetailModel;
import com.lemon.domain.repository.TvShowsRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * A UseCase class for getting tv show details
 */
public final class GetTvShowDetailsUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public GetTvShowDetailsUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<TvShowDetailModel> execute(final int tvShowId) {
        return mTvShowsRepository.getTvShowDetailsById(tvShowId);
    }

    public Observable<TvShowDetailModel> execute() {
        return mTvShowsRepository.getRandomTvShowDetails();
    }

}
