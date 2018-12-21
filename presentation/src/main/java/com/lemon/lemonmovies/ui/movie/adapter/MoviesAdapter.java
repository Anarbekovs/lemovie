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
import com.lemon.lemonmovies.listener.OnMovieMenuClickListener;
import com.lemon.lemonmovies.model.item.MovieItemDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieHolder> {

    private List<MovieItemDataModel> mMovies;
    private final OnMovieClickListener mListener;
    private final OnMovieMenuClickListener mMenuListener;

    public MoviesAdapter(final OnMovieClickListener listener, final OnMovieMenuClickListener menuListener) {
        this.mMovies = new ArrayList<>();
        this.mListener = listener;
        this.mMenuListener = menuListener;
    }

    @Override
    public MovieHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new MovieHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(final MovieHolder holder, final int position) {
        final MovieItemDataModel currentMovie = mMovies.get(position);
        holder.mReleaseYearTextView.setText(currentMovie.getMovieReleaseDate());
        holder.mTitleTextView.setText(currentMovie.getMovieTitle());
        holder.mGenreTextView.setText(currentMovie.getMovieGenres());
        holder.mRatingTextView.setText(currentMovie.getMovieRating());
        holder.mTmdbRatingTextView.setText(currentMovie.getMovieTmdbRating());

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

    public void setMovies(final List<MovieItemDataModel> movies) {
        this.mMovies = movies;
        notifyDataSetChanged();
    }

    public void clearMovies() {
        mMovies.clear();
        notifyDataSetChanged();
    }

    private MovieItemDataModel getMovie(final int position) {
        return mMovies.get(position);
    }

    public final class MovieHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_poster_image)
        ImageView mPosterImageView;
        @BindView(R.id.movie_release_year)
        TextView mReleaseYearTextView;
        @BindView(R.id.movie_title)
        TextView mTitleTextView;
        @BindView(R.id.movie_genres)
        TextView mGenreTextView;
        @BindView(R.id.movie_rating)
        TextView mRatingTextView;
        @BindView(R.id.movie_tmdb_rating)
        TextView mTmdbRatingTextView;

        @OnClick(R.id.movie_container)
        void onItemClick() {
            mListener.onMovieClick(getMovie(getLayoutPosition()).getMovieId());
        }

        @OnClick(R.id.movie_context_menu)
        void onContextMenuClick(final View view) {
            mMenuListener.onMovieMenuClick(getMovie(getLayoutPosition()).getMovieId(), view);
        }

        MovieHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
