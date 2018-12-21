package com.lemon.lemonmovies.ui.person.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.lemon.lemonmovies.GlideApp;
import com.lemon.lemonmovies.R;
import com.lemon.lemonmovies.listener.OnPersonClickListener;
import com.lemon.lemonmovies.model.result.PersonResultDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class PersonsResultAdapter extends RecyclerView.Adapter<PersonsResultAdapter.PersonResultHolder> {

    private List<PersonResultDataModel> mPersons;
    private final OnPersonClickListener mListener;

    public PersonsResultAdapter(final OnPersonClickListener listener) {
        this.mPersons = new ArrayList<>();
        this.mListener = listener;
    }

    @Override
    public PersonResultHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new PersonResultHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_result_person, parent, false));
    }

    @Override
    public void onBindViewHolder(final PersonResultHolder holder, final int position) {
        final PersonResultDataModel currentPerson = mPersons.get(position);
        holder.mPersonNameTextView.setText(currentPerson.getPersonName());
        holder.mPersonKnownForTextView.setText(currentPerson.getPersonKnownFor());

        GlideApp.with(holder.itemView.getContext())
                .load(currentPerson.getPersonPhoto())
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.color.color_image_placeholder)
                .into(holder.mPersonPhotoImageView);
    }

    @Override
    public int getItemCount() {
        return mPersons.size();
    }

    public void setPersons(final List<PersonResultDataModel> persons) {
        this.mPersons = persons;
        notifyDataSetChanged();
    }

    private PersonResultDataModel getPerson(final int position) {
        return mPersons.get(position);
    }

    public final class PersonResultHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.result_person_photo)
        ImageView mPersonPhotoImageView;
        @BindView(R.id.result_person_name)
        TextView mPersonNameTextView;
        @BindView(R.id.result_person_known_for)
        TextView mPersonKnownForTextView;

        @OnClick(R.id.result_person_container)
        void onClick() {
            mListener.onPersonClick(getPerson(getLayoutPosition()).getPersonId());
        }

        PersonResultHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
