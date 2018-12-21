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
import com.lemon.lemonmovies.model.result.MovieResultDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class MoviesResultAdapter extends RecyclerView.Adapter<MoviesResultAdapter.MovieResultHolder> {

    private List<MovieResultDataModel> mMovies;
    private final OnMovieClickListener mListener;

    public MoviesResultAdapter(final OnMovieClickListener listener) {
        this.mMovies = new ArrayList<>();
        this.mListener = listener;
    }

    @Override
    public MovieResultHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new MovieResultHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_result_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(final MovieResultHolder holder, final int position) {
        final MovieResultDataModel currentMovie = mMovies.get(position);
        holder.mTitleTextView.setText(currentMovie.getMovieTitle());
        holder.mReleaseYearTextView.setText(currentMovie.getMovieReleaseDate());

        GlideApp.with(holder.itemView.getContext())
                .load(currentMovie.getMoviePoster())
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

    public void setMovies(final List<MovieResultDataModel> movies) {
        this.mMovies = movies;
        notifyDataSetChanged();
    }

    private MovieResultDataModel getMovie(final int position) {
        return mMovies.get(position);
    }

    public final class MovieResultHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.result_movie_poster)
        ImageView mPosterImageView;
        @BindView(R.id.result_movie_title)
        TextView mTitleTextView;
        @BindView(R.id.result_movie_release_year)
        TextView mReleaseYearTextView;

        @OnClick(R.id.result_movie_container)
        void onItemClick() {
            mListener.onMovieClick(getMovie(getLayoutPosition()).getMovieId());
        }

        MovieResultHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
