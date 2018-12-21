package com.lemon.domain.usecase.person;

import com.lemon.domain.repository.PersonsRepository;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * A UseCase class for deleting person from collection
 */
public final class DeletePersonUseCase {

    private final PersonsRepository mPersonsRepository;

    @Inject
    public DeletePersonUseCase(final PersonsRepository personsRepository) {
        this.mPersonsRepository = personsRepository;
    }

    public Disposable execute(final int personId) {
        return mPersonsRepository.deletePersonById(personId);
    }
}
