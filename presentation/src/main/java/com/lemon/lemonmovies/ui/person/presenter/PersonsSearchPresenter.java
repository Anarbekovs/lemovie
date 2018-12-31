package com.lemon.lemonmovies.ui.person.presenter;

import com.lemon.lemonmovies.di.scope.PersonsScope;
import com.lemon.lemonmovies.mapper.PersonResultDataModelMapper;
import com.lemon.lemonmovies.model.result.PersonResultDataModel;
import com.lemon.lemonmovies.ui.base.BasePresenter;
import com.lemon.lemonmovies.ui.person.view.PersonsSearchView;
import com.lemon.domain.usecase.person.SearchPersonsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@PersonsScope
public final class PersonsSearchPresenter extends BasePresenter<PersonsSearchView> {

    private final SearchPersonsUseCase mSearchPersonsUseCase;
    private static final int mPage = 1; //todo stub

    @Inject
    public PersonsSearchPresenter(final SearchPersonsUseCase searchPersonsUseCase) {
        this.mSearchPersonsUseCase = searchPersonsUseCase;
    }

    public void searchPersonsByQuery(final String query) {
        addDisposable(mSearchPersonsUseCase.execute(query, mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(PersonResultDataModelMapper::transform)
                .subscribe(this::showPersonsSearchResult,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showPersonsSearchResult(final List<PersonResultDataModel> persons) {
        if (persons != null && !persons.isEmpty()) {
            Timber.i("Persons search successful, found: %s", persons.size());
            mView.hideEmptyText();
            mView.showPersonsSearchResult(persons);
        } else {
            Timber.w("Persons search failed: empty list");
            mView.showEmptyText();
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Persons search error: %s", message);
    }
}
