package com.lemon.lemonmovies.mapper;

import com.lemon.lemonmovies.mapper.utils.ConvertUtils;
import com.lemon.lemonmovies.mapper.utils.DateUtils;
import com.lemon.lemonmovies.model.item.MovieItemDataModel;
import com.lemon.domain.model.item.MovieItemModel;

import java.util.ArrayList;
import java.util.List;

public final class MovieItemDataModelMapper {

    public static List<MovieItemDataModel> transform(final List<MovieItemModel> models) {
        final List<MovieItemDataModel> movies = new ArrayList<>();
        for (final MovieItemModel model : models) {
            movies.add(transform(model));
        }
        return movies;
    }

    public static MovieItemDataModel transform(final MovieItemModel model) {
        return MovieItemDataModel.newBuilder()
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
