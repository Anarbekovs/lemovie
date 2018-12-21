package com.lemon.lemonmovies.mapper;

import com.lemon.lemonmovies.mapper.utils.DateUtils;
import com.lemon.lemonmovies.model.detail.PersonDetailDataModel;
import com.lemon.lemonmovies.model.detail.credits.MovieCreditDataModel;
import com.lemon.lemonmovies.model.detail.credits.TvShowCreditDataModel;
import com.lemon.domain.model.detail.PersonDetailModel;
import com.lemon.domain.model.detail.credits.MovieCreditModel;
import com.lemon.domain.model.detail.credits.TvShowCreditModel;

import java.util.ArrayList;
import java.util.List;

public final class PersonDetailDataModelMapper {

    public static List<PersonDetailDataModel> transform(final List<PersonDetailModel> models) {
        final List<PersonDetailDataModel> persons = new ArrayList<>();
        for (final PersonDetailModel model : models) {
            persons.add(transform(model));
        }
        return persons;
    }

    public static PersonDetailDataModel transform(final PersonDetailModel model) {
        return PersonDetailDataModel.newBuilder()
                .setId(model.getId())
                .setPhoto(model.getPhoto())
                .setPhotoPreview(model.getPhotoPreview())
                .setName(model.getName())
                .setBiography(model.getBiography())
                .setBirthday(DateUtils.parsePersonDate(model.getBirthday()))
                .setDeathday(DateUtils.parsePersonDate(model.getDeathday()))
                .setKnownAs(model.getKnownAs())
                .setFavorite(model.isFavorite())
                .setMovies(transformMoviesCredits(model.getMoviesCredits()))
                .setTvShows(transformTvShowsCredits(model.getTvShowsCredits()))
                .build();
    }

    private static List<MovieCreditDataModel> transformMoviesCredits(final List<MovieCreditModel> movies) {
        final List<MovieCreditDataModel> credits = new ArrayList<>();
        for (final MovieCreditModel movie : movies) {
            credits.add(new MovieCreditDataModel(
                    movie.getId(),
                    movie.getTitle(),
                    movie.getCharacter(),
                    movie.getPoster())
            );
        }
        return credits;
    }

    private static List<TvShowCreditDataModel> transformTvShowsCredits(final List<TvShowCreditModel> tvShows) {
        final List<TvShowCreditDataModel> credits = new ArrayList<>();
        for (final TvShowCreditModel tvShow : tvShows) {
            credits.add(new TvShowCreditDataModel(
                    tvShow.getId(),
                    tvShow.getTitle(),
                    tvShow.getCharacter(),
                    tvShow.getPoster())
            );
        }
        return credits;
    }
}
