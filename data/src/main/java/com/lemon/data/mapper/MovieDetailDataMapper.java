package com.lemon.data.mapper;

import com.lemon.data.local.entity.MovieEntity;
import com.lemon.data.local.entity.credits.PersonCredit;
import com.lemon.domain.model.detail.MovieDetailModel;
import com.lemon.domain.model.detail.credits.PersonCreditModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A Mapper which transforms MovieDetail from data-layer model to domain-layer model
 */
public final class MovieDetailDataMapper {

    /**
     * Transforms movie data-layer model {@link MovieEntity} to movie detail domain-layer model {@link MovieDetailModel}
     *
     * @param entity - a movie detail data-layer model for transform
     * @return transformed movie detail domain-layer model
     */
    public static MovieDetailModel transform(final MovieEntity entity) {
        final List<PersonCredit> crewList = entity.getDirectors();
        crewList.addAll(entity.getWriters());

        return new MovieDetailModel(
                entity.getId(),
                entity.getTitle(),
                entity.getOriginalTitle(),
                entity.getTagLine(),
                entity.getReleaseDate(),
                entity.getGenres(),
                entity.getPoster(),
                entity.getPosterPreview(),
                entity.getAllPosters(),
                entity.getDescription(),
                entity.getBudget(),
                entity.getRevenue(),
                entity.getStatus(),
                entity.getLanguage(),
                entity.getRuntime(),
                entity.getRating(),
                entity.getTmdbRating(),
                entity.getVotesCount(),
                entity.isWatchlist(),
                entity.isFavorite(),
                transformPersonCredits(entity.getActors()),
                transformPersonCredits(crewList)
        );
    }

    /**
     * Transforms list of persons which are credits to the movie {@link List<PersonCredit>} from data-layer model
     * to domain-layer model {@link List<PersonCreditModel>}
     *
     * @param credits - a list of person credits data-layer model
     * @return transformed list of person credits domain-layer model
     */
    private static List<PersonCreditModel> transformPersonCredits(final List<PersonCredit> credits) {
        final List<PersonCreditModel> models = new ArrayList<>();
        for (final PersonCredit credit : credits) {
            models.add(new PersonCreditModel(
                    credit.getId(),
                    credit.getName(),
                    credit.getCharacter(),
                    credit.getPhoto())
            );
        }
        return models;
    }
}
