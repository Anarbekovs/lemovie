package com.lemon.data.mapper;

import com.lemon.data.local.entity.TvShowEntity;
import com.lemon.data.local.entity.credits.PersonCredit;
import com.lemon.domain.model.detail.TvShowDetailModel;
import com.lemon.domain.model.detail.credits.PersonCreditModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A Mapper which transforms TvShowDetail from data-layer model to domain-layer model
 */
public final class TvShowDetailDataMapper {

    /**
     * Transforms tv show data-layer model {@link TvShowEntity} to tv show detail domain-layer model {@link TvShowDetailModel}
     *
     * @param entity - a tv show detail data-layer model for transform
     * @return transformed tv show detail domain-layer model
     */
    public static TvShowDetailModel transform(final TvShowEntity entity) {
        return new TvShowDetailModel(
                entity.getId(),
                entity.getTitle(),
                entity.getOriginalTitle(),
                entity.getFirstAirDate(),
                entity.getGenres(),
                entity.getPoster(),
                entity.getPosterPreview(),
                entity.getAllPosters(),
                entity.getDescription(),
                entity.getStatus(),
                entity.isIsInProduction(),
                entity.getEpisodesCount(),
                entity.getSeasonsCount(),
                entity.getLanguage(),
                entity.getNetwork(),
                entity.getEpisodeRuntime(),
                entity.getRating(),
                entity.getTmdbRating(),
                entity.getVotesCount(),
                entity.isWatchlist(),
                entity.isFavorite(),
                transformPersonCredits(entity.getCreators()),
                transformPersonCredits(entity.getActors())
        );
    }

    /**
     * Transforms list of persons which are credits to the tv show {@link List<PersonCredit>} from data-layer model
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
