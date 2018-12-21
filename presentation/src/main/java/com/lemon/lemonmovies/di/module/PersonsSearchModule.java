package com.lemon.lemonmovies.di.module;

import com.lemon.lemonmovies.di.scope.PersonsScope;
import com.lemon.lemonmovies.ui.person.presenter.PersonsSearchPresenter;
import com.lemon.domain.repository.PersonsRepository;
import com.lemon.domain.usecase.person.SearchPersonsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class PersonsSearchModule {

    @Provides
    @PersonsScope
    PersonsSearchPresenter providesPersonsSearchPresenter(final SearchPersonsUseCase searchPersonsUseCase) {
        return new PersonsSearchPresenter(searchPersonsUseCase);
    }

    @Provides
    @PersonsScope
    SearchPersonsUseCase providesSearchPersonsUseCase(final PersonsRepository personsRepository) {
        return new SearchPersonsUseCase(personsRepository);
    }
}
