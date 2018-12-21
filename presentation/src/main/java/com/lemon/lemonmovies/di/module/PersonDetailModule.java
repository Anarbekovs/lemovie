package com.lemon.lemonmovies.di.module;

import com.lemon.lemonmovies.di.scope.PersonsScope;
import com.lemon.lemonmovies.ui.person.presenter.PersonDetailPresenter;
import com.lemon.domain.repository.PersonsRepository;
import com.lemon.domain.usecase.person.AddPersonUseCase;
import com.lemon.domain.usecase.person.DeletePersonUseCase;
import com.lemon.domain.usecase.person.GetPersonDetailsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class PersonDetailModule {

    @Provides
    @PersonsScope
    PersonDetailPresenter providesPersonDetailPresenter(final GetPersonDetailsUseCase getPersonDetailsUseCase,
                                                        final AddPersonUseCase addPersonUseCase,
                                                        final DeletePersonUseCase deletePersonUseCase) {
        return new PersonDetailPresenter(getPersonDetailsUseCase, addPersonUseCase, deletePersonUseCase);
    }

    @Provides
    @PersonsScope
    GetPersonDetailsUseCase providesGetPersonDetailsUseCase(final PersonsRepository personsRepository) {
        return new GetPersonDetailsUseCase(personsRepository);
    }
}
