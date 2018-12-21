package com.lemon.lemonmovies.ui.person.view;

import com.lemon.lemonmovies.model.result.PersonResultDataModel;
import com.lemon.lemonmovies.ui.base.BaseView;

import java.util.List;

public interface PersonsPopularView extends BaseView {

    void showPopularPersons(final List<PersonResultDataModel> persons);
}
