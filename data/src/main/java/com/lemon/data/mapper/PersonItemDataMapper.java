package com.lemon.data.mapper;

import com.lemon.data.local.entity.PersonEntity;
import com.lemon.domain.model.item.PersonItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A Mapper which transforms PersonItemModel from data-layer model to domain-layer model
 */
public final class PersonItemDataMapper {

    /**
     * Transforms list of person data-layer model {@link List<PersonEntity>}
     * to list of person item domain-layer model {@link List<PersonItemModel>}
     *
     * @param entities - a list of person data-layer model
     * @return transformed list of person item domain-layer model
     */
    public static List<PersonItemModel> transform(final List<PersonEntity> entities) {
        final List<PersonItemModel> models = new ArrayList<>();
        for (final PersonEntity entity : entities) {
            models.add(transform(entity));
        }
        return models;
    }

    /**
     * Transforms person data-layer model {@link PersonEntity} to person item domain-layer model {@link PersonItemModel}
     *
     * @param entity - a person data-layer model
     * @return transformed person item domain-layer model.
     */
    public static PersonItemModel transform(final PersonEntity entity) {
        return new PersonItemModel(
                entity.getId(),
                entity.getName(),
                entity.getKnownAs(),
                entity.getPhotoPreview()
        );
    }
}
