package com.lemon.domain.usecase.person;

import com.lemon.domain.repository.PersonsRepository;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * A UseCase class for adding person to collection
 */
public final class AddPersonUseCase {

    private final PersonsRepository mPersonsRepository;

    @Inject
    public AddPersonUseCase(final PersonsRepository personsRepository) {
        this.mPersonsRepository = personsRepository;
    }

    public Disposable execute(final int personId) {
        return mPersonsRepository.addPersonById(personId);
    }
}
