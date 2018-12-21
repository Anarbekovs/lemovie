package com.lemon.lemonmovies.ui.person.view;

import com.lemon.lemonmovies.model.item.PersonItemDataModel;
import com.lemon.lemonmovies.ui.base.BaseView;

import java.util.List;

public interface PersonsView extends BaseView {

    void setPersons(final List<PersonItemDataModel> persons);

    void clearPersons();

    void showEmptyText();

    void hideEmptyText();
}
