package com.lemon.data.mapper;

import com.lemon.data.local.entity.MovieEntity;
import com.lemon.domain.model.item.MovieItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A Mapper which transforms MovieItemModel from data-layer model to domain-layer model
 */
public final class MovieItemDataMapper {

    /**
     * Transforms list of movie data-layer model {@link List<MovieEntity>}
     * to list of movie item domain-layer model {@link List<MovieItemModel>}
     *
     * @param entities - a list of movie data-layer model
     * @return transformed list of movie item domain-layer model
     */
    public static List<MovieItemModel> transform(final List<MovieEntity> entities) {
        final List<MovieItemModel> models = new ArrayList<>();
        for (final MovieEntity entity : entities) {
            models.add(transform(entity));
        }
        return models;
    }

    /**
     * Transforms movie data-layer model {@link MovieEntity} to movie item domain-layer model {@link MovieItemModel}
     *
     * @param entity - a movie data-layer model
     * @return transformed movie item domain-layer model.
     */
    public static MovieItemModel transform(final MovieEntity entity) {
        return new MovieItemModel(
                entity.getId(),
                entity.getTitle(),
                entity.getPosterPreview(),
                entity.getReleaseDate(),
                entity.getGenres(),
                entity.getRating(),
                entity.getTmdbRating()
        );
    }
}
