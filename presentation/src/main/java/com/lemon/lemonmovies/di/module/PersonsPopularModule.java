package com.lemon.lemonmovies.di.module;

import com.lemon.lemonmovies.di.scope.PersonsScope;
import com.lemon.lemonmovies.ui.person.presenter.PersonsPopularPresenter;
import com.lemon.domain.repository.PersonsRepository;
import com.lemon.domain.usecase.person.GetPopularPersonsUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public final class PersonsPopularModule {

    @Provides
    @PersonsScope
    PersonsPopularPresenter providesPersonsPopularPresenter(final GetPopularPersonsUseCase getPopularPersonsUseCase) {
        return new PersonsPopularPresenter(getPopularPersonsUseCase);
    }

    @Provides
    @PersonsScope
    GetPopularPersonsUseCase providesGetPopularPersonsUseCase(final PersonsRepository personsRepository) {
        return new GetPopularPersonsUseCase(personsRepository);
    }
}
