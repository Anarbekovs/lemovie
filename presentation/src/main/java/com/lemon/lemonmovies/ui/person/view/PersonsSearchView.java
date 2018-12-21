package com.lemon.lemonmovies.ui.person.view;

import com.lemon.lemonmovies.model.result.PersonResultDataModel;
import com.lemon.lemonmovies.ui.base.BaseView;

import java.util.List;

public interface PersonsSearchView extends BaseView {

    void showPersonsSearchResult(final List<PersonResultDataModel> persons);

    void showEmptyText();

    void hideEmptyText();
}
