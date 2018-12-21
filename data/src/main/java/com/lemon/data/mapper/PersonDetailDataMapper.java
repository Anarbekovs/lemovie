package com.lemon.data.mapper;

import com.lemon.data.local.entity.PersonEntity;
import com.lemon.data.local.entity.credits.MovieCredit;
import com.lemon.data.local.entity.credits.TvShowCredit;
import com.lemon.domain.model.detail.PersonDetailModel;
import com.lemon.domain.model.detail.credits.MovieCreditModel;
import com.lemon.domain.model.detail.credits.TvShowCreditModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A Mapper which transforms PersonDetail from data-layer model to domain-layer model
 */
public final class PersonDetailDataMapper {

    /**
     * Transforms person data-layer model {@link PersonEntity} to person detail domain-layer model {@link PersonDetailModel}
     *
     * @param entity - a person detail data-layer model for transform
     * @return transformed person detail domain-layer model
     */
    public static PersonDetailModel transform(final PersonEntity entity) {
        return new PersonDetailModel(
                entity.getId(),
                entity.getName(),
                entity.getKnownAs(),
                entity.getBirthday(),
                entity.getDeathday(),
                entity.getBiography(),
                entity.getPhoto(),
                entity.getPhotoPreview(),
                entity.isFavorite(),
                transformTvShowsCredits(entity.getTvShowsCredits()),
                transformMoviesCredits(entity.getMoviesCredits())
        );
    }

    /**
     * Transforms list of tv shows which are credits to the person {@link List<TvShowCredit>} from data-layer model
     * to domain-layer model {@link List<TvShowCreditModel>}
     *
     * @param credits - a list of tv show credits data-layer model
     * @return transformed list of tv show credits domain-layer model
     */
    private static List<TvShowCreditModel> transformTvShowsCredits(final List<TvShowCredit> credits) {
        final List<TvShowCreditModel> models = new ArrayList<>();
        for (final TvShowCredit credit : credits) {
            models.add(new TvShowCreditModel(
                    credit.getId(),
                    credit.getTitle(),
                    credit.getCharacter(),
                    credit.getPoster())
            );
        }
        return models;
    }

    /**
     * Transforms list of movies which are credits to the person {@link List<MovieCredit>} from data-layer model
     * to domain-layer model {@link List<MovieCreditModel>}
     *
     * @param credits - a list of movie credits data-layer model
     * @return transformed list of movie credits domain-layer model
     */
    private static List<MovieCreditModel> transformMoviesCredits(final List<MovieCredit> credits) {
        final List<MovieCreditModel> models = new ArrayList<>();
        for (final MovieCredit credit : credits) {
            models.add(new MovieCreditModel(
                    credit.getId(),
                    credit.getTitle(),
                    credit.getCharacter(),
                    credit.getPoster())
            );
        }
        return models;
    }
}
