package com.lemon.domain.usecase.tvshow;

import com.lemon.domain.model.result.TvShowResultModel;
import com.lemon.domain.repository.TvShowsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * A UseCase class for getting popular tv shows
 */
public final class GetPopularTvShowsUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public GetPopularTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<List<TvShowResultModel>> execute(final int page) {
        return mTvShowsRepository.getPopularTvShows(page);
    }
}
