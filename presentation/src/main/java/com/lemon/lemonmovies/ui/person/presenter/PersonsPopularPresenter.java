package com.lemon.lemonmovies.ui.person.presenter;

import com.lemon.lemonmovies.di.scope.PersonsScope;
import com.lemon.lemonmovies.mapper.PersonResultDataModelMapper;
import com.lemon.lemonmovies.model.result.PersonResultDataModel;
import com.lemon.lemonmovies.ui.base.BasePresenter;
import com.lemon.lemonmovies.ui.person.view.PersonsPopularView;
import com.lemon.domain.usecase.person.GetPopularPersonsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@PersonsScope
public final class PersonsPopularPresenter extends BasePresenter<PersonsPopularView> {

    private final GetPopularPersonsUseCase mGetPopularPersonsUseCase;

    @Inject
    public PersonsPopularPresenter(final GetPopularPersonsUseCase getPopularPersonsUseCase) {
        this.mGetPopularPersonsUseCase = getPopularPersonsUseCase;
    }

    public void getPopularPersons() {
        addDisposable(mGetPopularPersonsUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(PersonResultDataModelMapper::transform)
                .subscribe(this::showPopularPersons,
                        throwable -> showErrorMessage(throwable.getLocalizedMessage())));
    }

    private void showPopularPersons(final List<PersonResultDataModel> persons) {
        if (persons != null && !persons.isEmpty()) {
            Timber.i("Popular persons loaded successful, size: %s", persons.size());
            mView.showPopularPersons(persons);
        } else {
            Timber.w("Popular persons load failed: empty list");
        }
    }

    private void showErrorMessage(final String message) {
        Timber.e("Popular persons load error: %s", message);
        mView.showSnackbar(message);
    }
}
