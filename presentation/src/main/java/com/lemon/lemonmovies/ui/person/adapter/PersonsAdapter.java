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
import com.lemon.lemonmovies.model.item.PersonItemDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.PersonHolder> {

    private List<PersonItemDataModel> mPersons;
    private final OnPersonClickListener mListener;

    public PersonsAdapter(final OnPersonClickListener listener) {
        this.mPersons = new ArrayList<>();
        this.mListener = listener;
    }

    @Override
    public PersonHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new PersonHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person, parent, false));
    }

    @Override
    public void onBindViewHolder(final PersonHolder holder, final int position) {
        final PersonItemDataModel currentPerson = mPersons.get(position);
        holder.mPersonNameTextView.setText(currentPerson.getPersonName());
        holder.mPersonKnownAsTextView.setText(currentPerson.getPersonKnownAs());

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

    public void setPersons(final List<PersonItemDataModel> persons) {
        this.mPersons = persons;
        notifyDataSetChanged();
    }

    public void clearPersons() {
        mPersons.clear();
        notifyDataSetChanged();
    }

    private PersonItemDataModel getPerson(final int position) {
        return mPersons.get(position);
    }

    public final class PersonHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.person_photo)
        ImageView mPersonPhotoImageView;
        @BindView(R.id.person_name)
        TextView mPersonNameTextView;
        @BindView(R.id.person_known_as)
        TextView mPersonKnownAsTextView;

        @OnClick(R.id.person_container)
        void onClick() {
            mListener.onPersonClick(getPerson(getLayoutPosition()).getPersonId());
        }

        PersonHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
