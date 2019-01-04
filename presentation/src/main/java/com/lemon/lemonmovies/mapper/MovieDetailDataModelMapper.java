package com.lemon.lemonmovies.mapper;

import com.lemon.lemonmovies.mapper.utils.ConvertUtils;
import com.lemon.lemonmovies.mapper.utils.DateUtils;
import com.lemon.lemonmovies.model.detail.MovieDetailDataModel;
import com.lemon.lemonmovies.model.detail.credits.PersonCreditDataModel;
import com.lemon.domain.model.detail.MovieDetailModel;
import com.lemon.domain.model.detail.credits.PersonCreditModel;

import java.util.ArrayList;
import java.util.List;

public final class MovieDetailDataModelMapper {

    public static List<MovieDetailDataModel> transform(final List<MovieDetailModel> models) {
        final List<MovieDetailDataModel> movies = new ArrayList<>();
        for (final MovieDetailModel model : models) {
            movies.add(transform(model));
        }
        return movies;
    }

    public static MovieDetailDataModel transform(final MovieDetailModel model) {
        return MovieDetailDataModel.newBuilder()
                .setId(model.getId())
                .setPoster(model.getPoster())
                .setPosterPreview(model.getPosterPreview())
                .setTitle(model.getTitle())
                .setOriginalTitle(model.getOriginalTitle())
                .setTagLine(model.getTagLine())
                .setReleaseDate(DateUtils.parseReleaseDate(model.getReleaseDate()))
                .setGenres(model.getGenres())
                .setAllPosters(model.getAllPosters())
                .setDescription(model.getDescription())
                .setBudget(ConvertUtils.convertMovieAmount(model.getBudget()))
                .setRevenue(ConvertUtils.convertMovieAmount(model.getRevenue()))
                .setMovieInfo(ConvertUtils.convertMovieInfo(model.getLanguage(), model.getRuntime(), model.getStatus()))
                .setRating(ConvertUtils.convertRating(model.getRating()))
                .setTmdbRating(ConvertUtils.convertTmdbRating(model.getTmdbRating()))
                .setVotesCount(String.valueOf(model.getVotesCount()))
                .setWatchlist(model.isWatchlist())
                .setFavorite(model.isFavorite())
                .setCast(transformPersonsCredits(model.getCast()))
                .setCrew(transformPersonsCredits(model.getCrew()))
                .setYoutubeKey(model.getYoutubeKey())
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
