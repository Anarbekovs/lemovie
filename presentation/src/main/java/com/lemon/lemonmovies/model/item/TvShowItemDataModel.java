package com.lemon.lemonmovies.model.item;

/**
 * Model that represents TvShowItem in presentation-layer
 */
public final class TvShowItemDataModel {

    private final int mTvShowId;
    private final String mTvShowTitle;
    private final String mTvShowPoster;
    private final String mTvShowReleaseDate;
    private final String mTvShowGenres;
    private final String mTvShowRating;
    private final String mTvShowTmdbRating;

    private TvShowItemDataModel(final Builder builder) {
        this.mTvShowId = builder.id;
        this.mTvShowTitle = builder.title;
        this.mTvShowPoster = builder.poster;
        this.mTvShowReleaseDate = builder.releaseDate;
        this.mTvShowGenres = builder.genres;
        this.mTvShowRating = builder.rating;
        this.mTvShowTmdbRating = builder.tmdbRating;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getTvShowId() {
        return mTvShowId;
    }

    public String getTvShowTitle() {
        return mTvShowTitle;
    }

    public String getTvShowPoster() {
        return mTvShowPoster;
    }

    public String getTvShowReleaseDate() {
        return mTvShowReleaseDate;
    }

    public String getTvShowGenres() {
        return mTvShowGenres;
    }

    public String getTvShowRating() {
        return mTvShowRating;
    }

    public String getTvShowTmdbRating() {
        return mTvShowTmdbRating;
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

        public TvShowItemDataModel build() {
            return new TvShowItemDataModel(this);
        }
    }
}
