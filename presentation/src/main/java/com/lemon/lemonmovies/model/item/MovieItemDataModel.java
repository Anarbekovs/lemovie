package com.lemon.lemonmovies.model.item;

/**
 * Model that represents MovieItem in presentation-layer
 */
public final class MovieItemDataModel {

    private final int mMovieId;
    private final String mMovieTitle;
    private final String mMoviePoster;
    private final String mMovieReleaseDate;
    private final String mMovieGenres;
    private final String mMovieRating;
    private final String mMovieTmdbRating;

    private MovieItemDataModel(final Builder builder) {
        this.mMovieId = builder.id;
        this.mMovieTitle = builder.title;
        this.mMoviePoster = builder.poster;
        this.mMovieReleaseDate = builder.releaseDate;
        this.mMovieGenres = builder.genres;
        this.mMovieRating = builder.rating;
        this.mMovieTmdbRating = builder.tmdbRating;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getMovieId() {
        return mMovieId;
    }

    public String getMovieTitle() {
        return mMovieTitle;
    }

    public String getMoviePoster() {
        return mMoviePoster;
    }

    public String getMovieReleaseDate() {
        return mMovieReleaseDate;
    }

    public String getMovieGenres() {
        return mMovieGenres;
    }

    public String getMovieRating() {
        return mMovieRating;
    }

    public String getMovieTmdbRating() {
        return mMovieTmdbRating;
    }

    public static final class Builder {

        private int id;
        private String title;
        private String poster;
        private String releaseDate;
        private String genres;
        private String rating;
        private String tmdbRating;

        private Builder() {
        }

        public Builder setId(final int id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(final String title) {
            this.title = title;
            return this;
        }

        public Builder setPoster(final String poster) {
            this.poster = poster;
            return this;
        }

        public Builder setReleaseDate(final String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder setGenres(final String genres) {
            this.genres = genres;
            return this;
        }

        public Builder setRating(final String rating) {
            this.rating = rating;
            return this;
        }

        public Builder setTmdbRating(final String tmdbRating) {
            this.tmdbRating = tmdbRating;
            return this;
        }

        public MovieItemDataModel build() {
            return new MovieItemDataModel(this);
        }
    }
}
