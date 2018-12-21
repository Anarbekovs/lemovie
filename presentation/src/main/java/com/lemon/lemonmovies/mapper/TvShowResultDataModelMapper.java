package com.lemon.lemonmovies.mapper;

import com.lemon.lemonmovies.mapper.utils.DateUtils;
import com.lemon.lemonmovies.model.result.TvShowResultDataModel;
import com.lemon.domain.model.result.TvShowResultModel;

import java.util.ArrayList;
import java.util.List;

public final class TvShowResultDataModelMapper {

    public static List<TvShowResultDataModel> transform(final List<TvShowResultModel> models) {
        final List<TvShowResultDataModel> tvShows = new ArrayList<>();
        for (final TvShowResultModel model : models) {
            tvShows.add(transform(model));
        }
        return tvShows;
    }

    public static TvShowResultDataModel transform(final TvShowResultModel model) {
        return TvShowResultDataModel.newBuilder()
                .setId(model.getId())
                .setPoster(model.getPoster())
                .setTitle(model.getTitle())
                .setReleaseDate(DateUtils.parseDateToYear(model.getReleaseDate()))
                .build();
    }
}
