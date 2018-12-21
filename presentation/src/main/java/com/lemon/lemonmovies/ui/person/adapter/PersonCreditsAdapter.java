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
import com.lemon.lemonmovies.model.detail.credits.PersonCreditDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class PersonCreditsAdapter extends RecyclerView.Adapter<PersonCreditsAdapter.PersonCreditHolder> {

    private List<PersonCreditDataModel> mPersons;
    private final OnPersonClickListener mListener;

    public PersonCreditsAdapter(final OnPersonClickListener listener) {
        this.mPersons = new ArrayList<>();
        this.mListener = listener;
    }

    @Override
    public PersonCreditHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new PersonCreditHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_credit_person, parent, false));
    }

    @Override
    public void onBindViewHolder(final PersonCreditHolder holder, final int position) {
        final PersonCreditDataModel currentPerson = mPersons.get(position);
        final String name = currentPerson.getName() != null ? currentPerson.getName()
                : holder.itemView.getResources().getString(R.string.credit_unknown_title);

        holder.mPersonNameTextView.setText(name);
        holder.mPersonCharacterTextView.setText(currentPerson.getCharacter());

        GlideApp.with(holder.itemView.getContext())
                .load(currentPerson.getPhoto())
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

    public void setPersons(final List<PersonCreditDataModel> persons) {
        this.mPersons = persons;
        notifyDataSetChanged();
    }

    private PersonCreditDataModel getPerson(final int position) {
        return mPersons.get(position);
    }

    public final class PersonCreditHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.credit_person_photo)
        ImageView mPersonPhotoImageView;
        @BindView(R.id.credit_person_name)
        TextView mPersonNameTextView;
        @BindView(R.id.credit_person_character)
        TextView mPersonCharacterTextView;

        @OnClick(R.id.credit_person_container)
        void onClick() {
            mListener.onPersonClick(getPerson(getLayoutPosition()).getId());
        }

        PersonCreditHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
