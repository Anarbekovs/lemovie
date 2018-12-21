package com.lemon.lemonmovies.mapper;

import com.lemon.lemonmovies.mapper.utils.ConvertUtils;
import com.lemon.lemonmovies.mapper.utils.DateUtils;
import com.lemon.lemonmovies.model.item.TvShowItemDataModel;
import com.lemon.domain.model.item.TvShowItemModel;

import java.util.ArrayList;
import java.util.List;

public final class TvShowItemDataModelMapper {

    public static List<TvShowItemDataModel> transform(final List<TvShowItemModel> models) {
        final List<TvShowItemDataModel> tvShows = new ArrayList<>();
        for (final TvShowItemModel model : models) {
            tvShows.add(transform(model));
        }
        return tvShows;
    }

    public static TvShowItemDataModel transform(final TvShowItemModel model) {
        return TvShowItemDataModel.newBuilder()
                .setId(model.getId())
                .setPoster(model.getPoster())
                .setTitle(model.getTitle())
                .setReleaseDate(DateUtils.parseDateToYear(model.getReleaseDate()))
                .setGenres(ConvertUtils.convertItemGenresToString(model.getGenres()))
                .setRating(ConvertUtils.convertRating(model.getRating()))
                .setTmdbRating(ConvertUtils.convertTmdbRating(model.getTmdbRating()))
                .build();
    }
}
