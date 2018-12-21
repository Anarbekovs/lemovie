package com.lemon.data.mapper;

import com.lemon.data.mapper.utils.PersonConvertUtils;
import com.lemon.data.remote.pojo.person.find.PersonResult;
import com.lemon.domain.model.result.PersonResultModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A Mapper which transforms PersonResultModel from data-layer model to domain-layer model
 */
public final class PersonResultDataMapper {

    /**
     * Transforms list of person results {@link List<PersonResult>}
     * to list of person result domain-layer model {@link List<PersonResultModel>}
     *
     * @param results - a list of person results
     * @return transformed list of person result domain-layer model
     */
    public static List<PersonResultModel> transform(final List<PersonResult> results) {
        final List<PersonResultModel> models = new ArrayList<>();
        for (final PersonResult result : results) {
            models.add(transform(result));
        }
        return models;
    }

    /**
     * Transforms person result {@link PersonResult} to person result domain-layer model {@link PersonResultModel}
     *
     * @param result - a person result
     * @return transformed person result domain-layer model
     */
    public static PersonResultModel transform(final PersonResult result) {
        return new PersonResultModel(
                result.getId(),
                result.getName(),
                PersonConvertUtils.convertKnownForDesc(result.getKnownFor()),
                PersonConvertUtils.convertPreviewImageUrl(result.getProfilePath())
        );
    }
}
