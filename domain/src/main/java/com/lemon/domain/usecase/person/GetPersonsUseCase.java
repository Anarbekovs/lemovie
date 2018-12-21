package com.lemon.domain.usecase.person;

import com.lemon.domain.model.item.PersonItemModel;
import com.lemon.domain.repository.PersonsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * A UseCase class for getting person collection
 */
public final class GetPersonsUseCase {

    private final PersonsRepository mPersonsRepository;

    @Inject
    public GetPersonsUseCase(final PersonsRepository personsRepository) {
        this.mPersonsRepository = personsRepository;
    }

    public Observable<List<PersonItemModel>> execute() {
        return mPersonsRepository.getFavoritePersons();
    }
}
