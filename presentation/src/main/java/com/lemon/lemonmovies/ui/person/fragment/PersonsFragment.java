package com.lemon.lemonmovies.ui.person.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lemon.lemonmovies.LemonMoviesApp;
import com.lemon.lemonmovies.LinearSpacingItemDecoration;
import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.RecyclerViewScrollListenerImpl;
import com.lemon.lemonmovies.listener.OnPersonClickListener;
import com.lemon.lemonmovies.model.item.PersonItemDataModel;
import com.lemon.lemonmovies.ui.base.BaseFragment;
import com.lemon.lemonmovies.ui.person.adapter.PersonsAdapter;
import com.lemon.lemonmovies.ui.person.presenter.PersonsPresenter;
import com.lemon.lemonmovies.ui.person.view.PersonsView;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;

public final class PersonsFragment extends BaseFragment implements PersonsView {

    public static final String TAG = PersonsFragment.class.getSimpleName();

    @BindView(R.id.rv_persons)
    RecyclerView mPersonsRecyclerView;
    @BindView(R.id.empty_persons)
    TextView mEmptyPersonsTextView;

    @Inject
    PersonsPresenter mPresenter;

    private PersonsAdapter mPersonsAdapter;
    private OnPersonClickListener mPersonClickListener;

    public static Fragment newInstance() {
        final PersonsFragment fragment = new PersonsFragment();
        final Bundle args = new Bundle();
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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_persons, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);

        initAdapter();
        prepareRecyclerView();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPersons();
    }

    private void initOnPersonClickListener(final Context context) {
        if (context instanceof OnPersonClickListener) {
            this.mPersonClickListener = (OnPersonClickListener) context;
        } else {
            throw new ClassCastException(getString(R.string.text_exception_no_listener_impl));
        }
    }

    private void initAdapter() {
        mPersonsAdapter = new PersonsAdapter(mPersonClickListener);
    }

    private void prepareRecyclerView() {
        final FloatingActionButton fab = Objects.requireNonNull(getActivity()).findViewById(R.id.fab_find_person);
        mPersonsRecyclerView.setAdapter(mPersonsAdapter);
        mPersonsRecyclerView.setWillNotDraw(false);
        mPersonsRecyclerView.addOnScrollListener(new RecyclerViewScrollListenerImpl(fab));
        mPersonsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        mPersonsRecyclerView.addItemDecoration(LinearSpacingItemDecoration.newBuilder()
                .setSpacing(getResources().getDimensionPixelSize(R.dimen.margin_half))
                .setOrientation(LinearLayoutManager.VERTICAL)
                .includeEdge(true)
                .build());
    }

    private void getPersons() {
        mPresenter.getPersons();
    }

    @Override
    public void setPersons(final List<PersonItemDataModel> persons) {
        mPersonsAdapter.setPersons(persons);
    }

    @Override
    public void clearPersons() {
        mPersonsAdapter.clearPersons();
    }

    @Override
    public void showEmptyText() {
        if (mEmptyPersonsTextView.getVisibility() == View.GONE) {
            mEmptyPersonsTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideEmptyText() {
        if (mEmptyPersonsTextView.getVisibility() == View.VISIBLE) {
            mEmptyPersonsTextView.setVisibility(View.GONE);
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
