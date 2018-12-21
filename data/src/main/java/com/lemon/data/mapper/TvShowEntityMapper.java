package com.lemon.data.mapper;

import com.lemon.data.local.entity.TvShowEntity;
import com.lemon.data.mapper.utils.TvShowConvertUtils;
import com.lemon.data.remote.pojo.tvshow.detail.TvShowDetail;

/**
 * A Mapper which transforms TvShowEntity from pojo to data-layer model.
 */
public final class TvShowEntityMapper {

    /**
     * Transforms tv show model from pojo {@link TvShowDetail} to data-layer model (entity) class {@link TvShowEntity}.
     *
     * @param tvShow - a tv show detail pojo-class received from remote
     * @return transformed tv show data-layer model
     */
    public static TvShowEntity transform(final TvShowDetail tvShow) {
        return new TvShowEntity(
                tvShow.getId(),
                tvShow.getTitle(),
                tvShow.getOriginalTitle(),
                tvShow.getFirstAirDate(),
                TvShowConvertUtils.convertGenres(tvShow.getGenres()),
                TvShowConvertUtils.convertOriginalImageUrl(tvShow.getPosterPath()),
                TvShowConvertUtils.convertPreviewImageUrl(tvShow.getPosterPath()),
                TvShowConvertUtils.convertPosters(tvShow.getImages().getPosters()),
                tvShow.getOverview(),
                tvShow.getStatus(),
                tvShow.isInProduction(),
                tvShow.getNumberOfEpisodes(),
                tvShow.getNumberOfSeasons(),
                tvShow.getOriginalLanguage(),
                TvShowConvertUtils.convertNetworks(tvShow.getNetworks()),
                TvShowConvertUtils.convertEpisodesRuntime(tvShow.getEpisodeRunTime()),
                tvShow.getVoteAverage(),
                tvShow.getVoteCount(),
                TvShowConvertUtils.convertCreators(tvShow.getCreatedBy()),
                TvShowConvertUtils.convertCastToActorsCredits(tvShow.getCredits().getCast()));
    }
}
