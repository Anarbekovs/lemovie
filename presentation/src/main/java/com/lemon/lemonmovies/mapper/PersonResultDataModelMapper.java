package com.lemon.lemonmovies.mapper;

import com.lemon.lemonmovies.model.result.PersonResultDataModel;
import com.lemon.domain.model.result.PersonResultModel;

import java.util.ArrayList;
import java.util.List;

public final class PersonResultDataModelMapper {

    public static List<PersonResultDataModel> transform(final List<PersonResultModel> models) {
        final List<PersonResultDataModel> persons = new ArrayList<>();
        for (final PersonResultModel model : models) {
            persons.add(transform(model));
        }
        return persons;
    }

    public static PersonResultDataModel transform(final PersonResultModel model) {
        return PersonResultDataModel.newBuilder()
                .setId(model.getId())
                .setPhoto(model.getPhoto())
                .setName(model.getName())
                .setKnownFor(model.getKnownFor())
                .build();
    }
}
