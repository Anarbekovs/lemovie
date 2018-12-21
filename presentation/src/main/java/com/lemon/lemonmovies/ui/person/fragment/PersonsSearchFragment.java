package com.lemon.lemonmovies.ui.person.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lemon.lemonmovies.BuildConfig;
import com.lemon.lemonmovies.LemonMoviesApp;
import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.listener.OnPersonClickListener;
import com.lemon.lemonmovies.model.result.PersonResultDataModel;
import com.lemon.lemonmovies.ui.base.BaseFragment;
import com.lemon.lemonmovies.ui.person.adapter.PersonsResultAdapter;
import com.lemon.lemonmovies.ui.person.presenter.PersonsSearchPresenter;
import com.lemon.lemonmovies.ui.person.view.PersonsSearchView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public final class PersonsSearchFragment extends BaseFragment implements PersonsSearchView {

    public static final String TAG = PersonsSearchFragment.class.getSimpleName();

    private static final String ARG_PERSONS_SEARCH_QUERY = BuildConfig.APPLICATION_ID + "ARG.PERSONS_SEARCH_QUERY";

    @BindView(R.id.rv_search_persons_result)
    RecyclerView mPersonsResultRecyclerView;
    @BindView(R.id.search_persons_empty)
    TextView mEmptySearchTextView;

    @Inject
    PersonsSearchPresenter mPresenter;

    private PersonsResultAdapter mPersonsResultAdapter;
    private OnPersonClickListener mPersonClickListener;

    public static Fragment newInstance(final String query) {
        final PersonsSearchFragment fragment = new PersonsSearchFragment();
        final Bundle args = new Bundle();
        args.putString(ARG_PERSONS_SEARCH_QUERY, query);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initOnPersonClickListener(context);
        ((LemonMoviesApp) context.getApplicationContext()).getAppComponent()
                .getPersonsSubComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_persons_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);

        initAdapter();
        prepareRecyclerView();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getArguments() != null) {
            performSearch(getArguments().getString(ARG_PERSONS_SEARCH_QUERY));
        }
    }

    private void initOnPersonClickListener(final Context context) {
        if (context instanceof OnPersonClickListener) {
            this.mPersonClickListener = (OnPersonClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
    }

    private void performSearch(final String query) {
        mPresenter.searchPersonsByQuery(query);
    }

    private void initAdapter() {
        mPersonsResultAdapter = new PersonsResultAdapter(mPersonClickListener);
    }

    private void prepareRecyclerView() {
        mPersonsResultRecyclerView.setAdapter(mPersonsResultAdapter);
        mPersonsResultRecyclerView.setWillNotDraw(false);
        mPersonsResultRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),
                getResources().getInteger(R.integer.grid_layout_span_count)));
    }

    @Override
    public void showPersonsSearchResult(final List<PersonResultDataModel> persons) {
        mPersonsResultAdapter.setPersons(persons);
    }

    @Override
    public void showEmptyText() {
        if (mEmptySearchTextView.getVisibility() == View.GONE) {
            mEmptySearchTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideEmptyText() {
        if (mEmptySearchTextView.getVisibility() == View.VISIBLE) {
            mEmptySearchTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter.disposeAll();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPersonClickListener = null;
    }
}
