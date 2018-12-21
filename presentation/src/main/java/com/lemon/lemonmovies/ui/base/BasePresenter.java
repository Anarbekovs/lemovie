package com.lemon.lemonmovies.ui.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * A abstract base class for all presenters
 *
 * @see BaseView
 */
public abstract class BasePresenter<T extends BaseView> {

    protected T mView;
    protected CompositeDisposable mDisposables = new CompositeDisposable();

    /**
     * Attaches view to presenter
     *
     * @param view - any view that extends {@link BaseView}
     */
    public void attachView(T view) {
        this.mView = view;
    }

    /**
     * Adds new {@link Disposable} to {@link CompositeDisposable}
     * @param disposable - a disposable resource
     */
    protected void addDisposable(final Disposable disposable) {
        if (disposable != null) {
            mDisposables.add(disposable);
        }
    }

    /**
     * Disposes {@link CompositeDisposable} with all not disposed {@link Disposable}
     */
    public void disposeAll() {
        if (!mDisposables.isDisposed()) {
            mDisposables.dispose();
        }
    }

    /**
     * Detaches view from presenter
     */
    public void detachView() {
        this.mView = null;
    }
}