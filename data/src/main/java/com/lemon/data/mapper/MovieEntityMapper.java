package com.lemon.data.mapper;

import com.lemon.data.local.entity.MovieEntity;
import com.lemon.data.mapper.utils.MovieConvertUtils;
import com.lemon.data.remote.pojo.movie.detail.MovieDetail;

/**
 * A Mapper which transforms MovieEntity from pojo to data-layer model.
 */
public final class MovieEntityMapper {

    /**
     * Transforms movie model from pojo {@link MovieDetail} to data-layer model (entity) class {@link MovieEntity}.
     *
     * @param movie - a movie detail pojo-class received from remote
     * @return transformed movie data-layer model
     */
    public static MovieEntity transform(final MovieDetail movie) {
        return new MovieEntity(
                movie.getId(),
                movie.getTitle(),
                movie.getOriginalTitle(),
                movie.getTagline(),
                movie.getReleaseDate(),
                MovieConvertUtils.convertGenres(movie.getGenres()),
                MovieConvertUtils.convertOriginalImageUrl(movie.getPosterPath()),
                MovieConvertUtils.convertPreviewImageUrl(movie.getPosterPath()),
                MovieConvertUtils.convertPosters(movie.getImages().getPosters()),
                movie.getOverview(),
                movie.getBudget(),
                movie.getRevenue(),
                movie.getStatus(),
                MovieConvertUtils.convertLanguages(movie.getSpokenLanguages()),
                movie.getRuntime(),
                movie.getVoteAverage(),
                movie.getVoteCount(),
                MovieConvertUtils.convertCastToActorsCredits(movie.getCredits().getCast()),
                MovieConvertUtils.convertCrewToDirectorsCredits(movie.getCredits().getCrew()),
                MovieConvertUtils.convertCrewToWritersCredits(movie.getCredits().getCrew()));
    }
}
