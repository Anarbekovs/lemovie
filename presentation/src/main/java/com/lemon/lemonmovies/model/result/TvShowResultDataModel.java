package com.lemon.lemonmovies.model.result;

/**
 * Model that represents TvShowResult in presentation-layer
 */
public final class TvShowResultDataModel {

    private final int mTvShowId;
    private final String mTvShowTitle;
    private final String mTvShowPoster;
    private final String mTvShowReleaseDate;

    private TvShowResultDataModel(final Builder builder) {
        this.mTvShowId = builder.id;
        this.mTvShowTitle = builder.title;
        this.mTvShowPoster = builder.poster;
        this.mTvShowReleaseDate = builder.releaseDate;
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

        public TvShowResultDataModel build() {
            return new TvShowResultDataModel(this);
        }
    }
}
