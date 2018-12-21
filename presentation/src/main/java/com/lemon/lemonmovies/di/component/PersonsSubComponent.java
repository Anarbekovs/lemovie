package com.lemon.lemonmovies.di.component;

import com.lemon.lemonmovies.di.module.PersonDetailModule;
import com.lemon.lemonmovies.di.module.PersonsModule;
import com.lemon.lemonmovies.di.module.PersonsPopularModule;
import com.lemon.lemonmovies.di.module.PersonsSearchModule;
import com.lemon.lemonmovies.di.scope.PersonsScope;
import com.lemon.lemonmovies.ui.person.fragment.PersonDetailFragment;
import com.lemon.lemonmovies.ui.person.fragment.PersonsFragment;
import com.lemon.lemonmovies.ui.person.fragment.PersonsPopularFragment;
import com.lemon.lemonmovies.ui.person.fragment.PersonsSearchFragment;

import dagger.Subcomponent;

@PersonsScope
@Subcomponent(modules = {PersonsModule.class, PersonDetailModule.class, PersonsSearchModule.class, PersonsPopularModule.class})
public interface PersonsSubComponent {

    void inject(final PersonsFragment personsFragment);

    void inject(final PersonDetailFragment personDetailFragment);

    void inject(final PersonsSearchFragment personsSearchFragment);

    void inject(final PersonsPopularFragment personsPopularFragment);
}
