package com.lemon.lemonmovies.ui.tvshow.adapter;

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
import com.lemon.lemonmovies.listener.OnTvShowClickListener;
import com.lemon.lemonmovies.model.detail.credits.TvShowCreditDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class TvShowCreditsAdapter extends RecyclerView.Adapter<TvShowCreditsAdapter.TvShowCreditHolder> {

    private List<TvShowCreditDataModel> mTvShows;
    private final OnTvShowClickListener mListener;

    public TvShowCreditsAdapter(final OnTvShowClickListener listener) {
        this.mTvShows = new ArrayList<>();
        this.mListener = listener;
    }

    @Override
    public TvShowCreditHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new TvShowCreditHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_credit_tv_show, parent, false));
    }

    @Override
    public void onBindViewHolder(final TvShowCreditHolder holder, final int position) {
        final TvShowCreditDataModel currentTvShow = mTvShows.get(position);
        final String title = currentTvShow.getTitle() != null ? currentTvShow.getTitle()
                : holder.itemView.getResources().getString(R.string.credit_unknown_title);

        holder.mTitleTextView.setText(title);
        holder.mCharacterTextView.setText(currentTvShow.getCharacter());

        GlideApp.with(holder.itemView.getContext())
                .load(currentTvShow.getPoster())
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.color.color_image_placeholder)
                .into(holder.mPosterImageView);
    }

    @Override
    public int getItemCount() {
        return mTvShows.size();
    }

    public void setTvShows(final List<TvShowCreditDataModel> tvShows) {
        this.mTvShows = tvShows;
        notifyDataSetChanged();
    }

    private TvShowCreditDataModel getTvShow(final int position) {
        return mTvShows.get(position);
    }

    public final class TvShowCreditHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.credit_tv_show_poster)
        ImageView mPosterImageView;
        @BindView(R.id.credit_tv_show_title)
        TextView mTitleTextView;
        @BindView(R.id.credit_tv_show_character)
        TextView mCharacterTextView;

        @OnClick(R.id.credit_tv_show_container)
        void onItemClick() {
            mListener.onTvShowClick(getTvShow(getLayoutPosition()).getId());
        }

        TvShowCreditHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
