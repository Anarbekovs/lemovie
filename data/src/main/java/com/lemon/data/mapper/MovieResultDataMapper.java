package com.lemon.data.mapper;

import com.lemon.data.mapper.utils.MovieConvertUtils;
import com.lemon.data.remote.pojo.movie.find.MovieResult;
import com.lemon.domain.model.result.MovieResultModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A Mapper which transforms MovieResultModel from data-layer model to domain-layer model
 */
public final class MovieResultDataMapper {

    /**
     * Transforms list of movie results {@link List<MovieResult>}
     * to list of movie result domain-layer model {@link List<MovieResultModel>}
     *
     * @param results - a list of movie results
     * @return transformed list of movie result domain-layer model
     */
    public static List<MovieResultModel> transform(final List<MovieResult> results) {
        final List<MovieResultModel> models = new ArrayList<>();
        for (final MovieResult result : results) {
            models.add(transform(result));
        }
        return models;
    }

    /**
     * Transforms movie result {@link MovieResult} to movie result domain-layer model {@link MovieResultModel}
     *
     * @param result - a movie result
     * @return transformed movie result domain-layer model
     */
    public static MovieResultModel transform(final MovieResult result) {
        return new MovieResultModel(
                result.getId(),
                result.getTitle(),
                MovieConvertUtils.convertPreviewImageUrl(result.getPosterPath()),
                result.getReleaseDate()
        );
    }
}
