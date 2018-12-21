package com.lemon.domain.usecase.person;

import com.lemon.domain.model.result.PersonResultModel;
import com.lemon.domain.repository.PersonsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * A UseCase class for search persons by query string
 */
public final class SearchPersonsUseCase {

    private final PersonsRepository mPersonsRepository;

    @Inject
    public SearchPersonsUseCase(final PersonsRepository personsRepository) {
        this.mPersonsRepository = personsRepository;
    }

    public Observable<List<PersonResultModel>> execute(final String query, final int page) {
        return mPersonsRepository.searchPersonsByQuery(query, page);
    }
}
