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
import com.lemon.lemonmovies.listener.OnTvShowMenuClickListener;
import com.lemon.lemonmovies.model.item.TvShowItemDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.TvShowHolder> {

    private List<TvShowItemDataModel> mTvShows;
    private final OnTvShowClickListener mListener;
    private final OnTvShowMenuClickListener mMenuListener;

    public TvShowsAdapter(final OnTvShowClickListener listener, final OnTvShowMenuClickListener menuListener) {
        this.mTvShows = new ArrayList<>();
        this.mListener = listener;
        this.mMenuListener = menuListener;
    }

    @Override
    public TvShowHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new TvShowHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tv_show, parent, false));
    }

    @Override
    public void onBindViewHolder(final TvShowHolder holder, final int position) {
        final TvShowItemDataModel currentTvShow = mTvShows.get(position);
        holder.mReleaseYearTextView.setText(currentTvShow.getTvShowReleaseDate());
        holder.mTitleTextView.setText(currentTvShow.getTvShowTitle());
        holder.mGenreTextView.setText(currentTvShow.getTvShowGenres());
        holder.mRatingTextView.setText(currentTvShow.getTvShowRating());
        holder.mTmdbRatingTextView.setText(currentTvShow.getTvShowTmdbRating());

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

    public void setTvShows(final List<TvShowItemDataModel> tvShows) {
        this.mTvShows = tvShows;
        notifyDataSetChanged();
    }

    public void clearTvShows() {
        mTvShows.clear();
        notifyDataSetChanged();
    }

    private TvShowItemDataModel getTvShow(final int position) {
        return mTvShows.get(position);
    }

    public final class TvShowHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_show_poster_image)
        ImageView mPosterImageView;
        @BindView(R.id.tv_show_release_year)
        TextView mReleaseYearTextView;
        @BindView(R.id.tv_show_title)
        TextView mTitleTextView;
        @BindView(R.id.tv_show_genres)
        TextView mGenreTextView;
        @BindView(R.id.tv_show_rating)
        TextView mRatingTextView;
        @BindView(R.id.tv_show_tmdb_rating)
        TextView mTmdbRatingTextView;

        @OnClick(R.id.tv_show_container)
        void onItemClick() {
            mListener.onTvShowClick(getTvShow(getLayoutPosition()).getTvShowId());
        }

        @OnClick(R.id.tv_show_context_menu)
        void onContextMenuClick(final View view) {
            mMenuListener.onTvShowMenuClick(getTvShow(getLayoutPosition()).getTvShowId(), view);
        }

        TvShowHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
