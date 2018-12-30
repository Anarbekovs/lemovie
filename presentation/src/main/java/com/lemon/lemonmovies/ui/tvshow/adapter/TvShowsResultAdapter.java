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
import com.lemon.lemonmovies.model.result.TvShowResultDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class TvShowsResultAdapter extends RecyclerView.Adapter<TvShowsResultAdapter.TvShowResultHolder> {

    private List<TvShowResultDataModel> mTvShows;
    private final OnTvShowClickListener mListener;

    public TvShowsResultAdapter(final OnTvShowClickListener listener) {
        this.mTvShows = new ArrayList<>();
        this.mListener = listener;
    }

    @Override
    public TvShowResultHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new TvShowResultHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_result_tv_show, parent, false));
    }

    @Override
    public void onBindViewHolder(final TvShowResultHolder holder, final int position) {
        final TvShowResultDataModel currentTvShow = mTvShows.get(position);
        holder.mTitleTextView.setText(currentTvShow.getTvShowTitle());
        holder.mReleaseYearTextView.setText(currentTvShow.getTvShowReleaseDate());

        GlideApp.with(holder.itemView.getContext())
                .load(currentTvShow.getTvShowPoster())
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.ic_live_tv_white_240dp)
                .into(holder.mPosterImageView);
    }

    @Override
    public int getItemCount() {
        return mTvShows.size();
    }

    public void setTvShows(final List<TvShowResultDataModel> tvShows) {
        this.mTvShows = tvShows;
        notifyDataSetChanged();
    }

    private TvShowResultDataModel getTvShow(final int position) {
        return mTvShows.get(position);
    }

    public final class TvShowResultHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.result_tv_show_poster)
        ImageView mPosterImageView;
        @BindView(R.id.result_tv_show_title)
        TextView mTitleTextView;
        @BindView(R.id.result_tv_show_release_year)
        TextView mReleaseYearTextView;

        @OnClick(R.id.result_tv_show_container)
        void onItemClick() {
            mListener.onTvShowClick(getTvShow(getLayoutPosition()).getTvShowId());
        }

        TvShowResultHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
