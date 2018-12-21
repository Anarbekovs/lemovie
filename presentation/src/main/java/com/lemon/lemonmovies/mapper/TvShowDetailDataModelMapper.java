package com.lemon.lemonmovies.mapper;

import com.lemon.lemonmovies.mapper.utils.ConvertUtils;
import com.lemon.lemonmovies.mapper.utils.DateUtils;
import com.lemon.lemonmovies.model.detail.TvShowDetailDataModel;
import com.lemon.lemonmovies.model.detail.credits.PersonCreditDataModel;
import com.lemon.domain.model.detail.TvShowDetailModel;
import com.lemon.domain.model.detail.credits.PersonCreditModel;

import java.util.ArrayList;
import java.util.List;

public final class TvShowDetailDataModelMapper {

    public static List<TvShowDetailDataModel> transform(final List<TvShowDetailModel> models) {
        final List<TvShowDetailDataModel> tvShows = new ArrayList<>();
        for (final TvShowDetailModel model : models) {
            tvShows.add(transform(model));
        }
        return tvShows;
    }

    public static TvShowDetailDataModel transform(final TvShowDetailModel model) {
        return TvShowDetailDataModel.newBuilder()
                .setId(model.getId())
                .setPoster(model.getPoster())
                .setPosterPreview(model.getPosterPreview())
                .setTitle(model.getTitle())
                .setOriginalTitle(model.getOriginalTitle())
                .setReleaseDate(DateUtils.parseReleaseDate(model.getReleaseDate()))
                .setGenres(model.getGenres())
                .setAllPosters(model.getAllPosters())
                .setDescription(model.getDescription())
                .setStatus(model.getStatus())
                .setInProduction(model.isInProduction())
                .setInfo(ConvertUtils.convertTvShowInfo(model.getSeasonsCount(), model.getEpisodesCount(), model.getEpisodeRuntime()))
                .setNetworkInfo(ConvertUtils.convertTvShowNetworkInfo(model.getLanguage(), model.getNetwork()))
                .setRating(ConvertUtils.convertRating(model.getRating()))
                .setTmdbRating(ConvertUtils.convertTmdbRating(model.getTmdbRating()))
                .setVotesCount(String.valueOf(model.getVotesCount()))
                .setWatchlist(model.isWatchlist())
                .setFavorite(model.isFavorite())
                .setCreators(transformPersonsCredits(model.getCreators()))
                .setActors(transformPersonsCredits(model.getActors()))
                .build();
    }

    private static List<PersonCreditDataModel> transformPersonsCredits(final List<PersonCreditModel> persons) {
        final List<PersonCreditDataModel> credits = new ArrayList<>();
        for (final PersonCreditModel person : persons) {
            credits.add(new PersonCreditDataModel(
                    person.getId(),
                    person.getName(),
                    person.getCharacter(),
                    person.getPhoto())
            );
        }
        return credits;
    }
}
