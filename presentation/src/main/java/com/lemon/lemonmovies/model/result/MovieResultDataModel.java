package com.lemon.lemonmovies.model.result;

/**
 * Model that represents MovieResult in presentation-layer
 */
public final class MovieResultDataModel {

    private final int mMovieId;
    private final String mMovieTitle;
    private final String mMoviePoster;
    private final String mMovieReleaseDate;

    private MovieResultDataModel(final Builder builder) {
        this.mMovieId = builder.id;
        this.mMovieTitle = builder.title;
        this.mMoviePoster = builder.poster;
        this.mMovieReleaseDate = builder.releaseDate;
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

    public static final class Builder {

        private int id;
        private String title;
        private String poster;
        private String releaseDate;

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

        public MovieResultDataModel build() {
            return new MovieResultDataModel(this);
        }
    }
}
