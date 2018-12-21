package com.lemon.lemonmovies.ui.person.view;

import com.lemon.lemonmovies.model.detail.PersonDetailDataModel;
import com.lemon.lemonmovies.ui.base.BaseView;

public interface PersonDetailView extends BaseView {

    void setPersonDetails(final PersonDetailDataModel person);

    void setFavoriteStatus(final boolean isFavorite);
}
