package com.lemon.domain.usecase.person;

import com.lemon.domain.model.result.PersonResultModel;
import com.lemon.domain.repository.PersonsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * A UseCase class for getting popular persons
 */
public final class GetPopularPersonsUseCase {

    private final PersonsRepository mPersonsRepository;

    @Inject
    public GetPopularPersonsUseCase(final PersonsRepository personsRepository) {
        this.mPersonsRepository = personsRepository;
    }

    public Observable<List<PersonResultModel>> execute(final int page) {
        return mPersonsRepository.getPopularPersons(page);
    }
}
