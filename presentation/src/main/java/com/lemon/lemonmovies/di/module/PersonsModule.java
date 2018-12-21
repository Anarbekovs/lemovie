package com.lemon.lemonmovies.di.module;

import com.lemon.lemonmovies.di.scope.PersonsScope;
import com.lemon.lemonmovies.ui.person.presenter.PersonsPresenter;
import com.lemon.domain.repository.PersonsRepository;
import com.lemon.domain.usecase.person.AddPersonUseCase;
import com.lemon.domain.usecase.person.DeletePersonUseCase;
import com.lemon.domain.usecase.person.GetPersonsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class PersonsModule {

    @Provides
    @PersonsScope
    PersonsPresenter providesPersonsPresenter(final GetPersonsUseCase getPersonsUseCase) {
        return new PersonsPresenter(getPersonsUseCase);
    }

    @Provides
    @PersonsScope
    GetPersonsUseCase providesGetPersonsUseCase(final PersonsRepository personsRepository) {
        return new GetPersonsUseCase(personsRepository);
    }

    @Provides
    @PersonsScope
    AddPersonUseCase providesAddPersonUseCase(final PersonsRepository personsRepository) {
        return new AddPersonUseCase(personsRepository);
    }

    @Provides
    @PersonsScope
    DeletePersonUseCase providesDeletePersonUseCase(final PersonsRepository personsRepository) {
        return new DeletePersonUseCase(personsRepository);
    }
}
