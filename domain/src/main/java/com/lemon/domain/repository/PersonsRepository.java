package com.lemon.domain.repository;

import com.lemon.domain.model.detail.PersonDetailModel;
import com.lemon.domain.model.item.PersonItemModel;
import com.lemon.domain.model.result.PersonResultModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * A PersonsRepository domain interface
 */
public interface PersonsRepository {

    /**
     * Getting a list of favorite persons
     *
     * @return {@link Observable} of person items list
     */
    Observable<List<PersonItemModel>> getFavoritePersons();

    /**
     * Getting a person details by id
     *
     * @param personId - a person id
     * @return {@link Observable} of person details
     */
    Observable<PersonDetailModel> getPersonDetailsById(final int personId);

    /**
     * Getting a list of popular persons
     * @return {@link Observable} of popular person results list
     */
    Observable<List<PersonResultModel>> getPopularPersons();

    /**
     * Getting a list of persons by search query
     *
     * @param query - a search query string
     * @param page  - a page number
     * @return {@link Observable} of person search results list
     */
    Observable<List<PersonResultModel>> searchPersonsByQuery(final String query, final int page);

    /**
     * Add person to favorites
     *
     * @param personId - a person id
     * @return {@link Disposable}
     */
    Disposable addPersonById(final int personId);

    /**
     * Delete person from favorites
     *
     * @param personId - a person id
     * @return {@link Disposable}
     */
    Disposable deletePersonById(final int personId);
}