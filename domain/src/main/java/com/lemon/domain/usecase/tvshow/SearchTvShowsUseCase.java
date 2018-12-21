package com.lemon.domain.usecase.tvshow;

import com.lemon.domain.model.result.TvShowResultModel;
import com.lemon.domain.repository.TvShowsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * A UseCase class for search tv shows by query string
 */
public final class SearchTvShowsUseCase {

    private final TvShowsRepository mTvShowsRepository;

    @Inject
    public SearchTvShowsUseCase(final TvShowsRepository tvShowsRepository) {
        this.mTvShowsRepository = tvShowsRepository;
    }

    public Observable<List<TvShowResultModel>> execute(final String query, final int page) {
        return mTvShowsRepository.searchTvShowsByQuery(query, page);
    }
}
