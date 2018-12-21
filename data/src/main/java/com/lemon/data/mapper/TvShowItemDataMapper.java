package com.lemon.data.mapper;

import com.lemon.data.local.entity.TvShowEntity;
import com.lemon.domain.model.item.TvShowItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A Mapper which transforms TvShowItemModel from data-layer model to domain-layer model
 */
public final class TvShowItemDataMapper {

    /**
     * Transforms list of tv show data-layer model {@link List<TvShowEntity>}
     * to list of tv show item domain-layer model {@link List<TvShowItemModel>}
     *
     * @param entities - a list of tv show data-layer model
     * @return transformed list of tv show item domain-layer model
     */
    public static List<TvShowItemModel> transform(final List<TvShowEntity> entities) {
        final List<TvShowItemModel> models = new ArrayList<>();
        for (final TvShowEntity entity : entities) {
            models.add(transform(entity));
        }
        return models;
    }

    /**
     * Transforms tv show data-layer model {@link TvShowEntity} to tv show item domain-layer model {@link TvShowItemModel}
     *
     * @param entity - a tv show data-layer model
     * @return transformed tv show item domain-layer model.
     */
    public static TvShowItemModel transform(final TvShowEntity entity) {
        return new TvShowItemModel(
                entity.getId(),
                entity.getTitle(),
                entity.getPosterPreview(),
                entity.getFirstAirDate(),
                entity.getGenres(),
                entity.getRating(),
                entity.getTmdbRating()
        );
    }
}
