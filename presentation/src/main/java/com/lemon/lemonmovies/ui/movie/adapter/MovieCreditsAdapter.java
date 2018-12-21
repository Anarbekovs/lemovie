package com.lemon.lemonmovies.ui.movie.adapter;

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
import com.lemon.lemonmovies.listener.OnMovieClickListener;
import com.lemon.lemonmovies.model.detail.credits.MovieCreditDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class MovieCreditsAdapter extends RecyclerView.Adapter<MovieCreditsAdapter.MovieCreditHolder> {

    private List<MovieCreditDataModel> mMovies;
    private final OnMovieClickListener mListener;

    public MovieCreditsAdapter(final OnMovieClickListener listener) {
        this.mMovies = new ArrayList<>();
        this.mListener = listener;
    }

    @Override
    public MovieCreditHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new MovieCreditHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_credit_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(final MovieCreditHolder holder, final int position) {
        final MovieCreditDataModel currentMovie = mMovies.get(position);
        final String title = currentMovie.getTitle() != null ? currentMovie.getTitle()
                : holder.itemView.getResources().getString(R.string.credit_unknown_title);

        holder.mTitleTextView.setText(title);
        holder.mCharacterTextView.setText(currentMovie.getCharacter());

        GlideApp.with(holder.itemView.getContext())
                .load(currentMovie.getPoster())
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.color.color_image_placeholder)
                .into(holder.mPosterImageView);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void setMovies(final List<MovieCreditDataModel> movies) {
        this.mMovies = movies;
        notifyDataSetChanged();
    }

    private MovieCreditDataModel getMovie(final int position) {
        return mMovies.get(position);
    }

    public final class MovieCreditHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.credit_movie_poster)
        ImageView mPosterImageView;
        @BindView(R.id.credit_movie_title)
        TextView mTitleTextView;
        @BindView(R.id.credit_movie_character)
        TextView mCharacterTextView;

        @OnClick(R.id.credit_movie_container)
        void onItemClick() {
            mListener.onMovieClick(getMovie(getLayoutPosition()).getId());
        }

        MovieCreditHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
