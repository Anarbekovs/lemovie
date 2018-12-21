package com.lemon.data.mapper;

import com.lemon.data.mapper.utils.TvShowConvertUtils;
import com.lemon.data.remote.pojo.tvshow.find.TvShowResult;
import com.lemon.domain.model.result.TvShowResultModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A Mapper which transforms TvShowResultModel from data-layer model to domain-layer model
 */
public final class TvShowResultDataMapper {

    /**
     * Transforms list of tv show results {@link List<TvShowResult>}
     * to list of tv show result domain-layer model {@link List<TvShowResultModel>}
     *
     * @param results - a list of tv show results
     * @return transformed list of tv show result domain-layer model
     */
    public static List<TvShowResultModel> transform(final List<TvShowResult> results) {
        final List<TvShowResultModel> models = new ArrayList<>();
        for (final TvShowResult result : results) {
            models.add(transform(result));
        }
        return models;
    }

    /**
     * Transforms tv show result {@link TvShowResult} to tv show result domain-layer model {@link TvShowResultModel}
     *
     * @param result - a tv show result
     * @return transformed tv show result domain-layer model
     */
    public static TvShowResultModel transform(final TvShowResult result) {
        return new TvShowResultModel(
                result.getId(),
                result.getName(),
                TvShowConvertUtils.convertPreviewImageUrl(result.getPosterPath()),
                result.getFirstAirDate()
        );
    }
}
