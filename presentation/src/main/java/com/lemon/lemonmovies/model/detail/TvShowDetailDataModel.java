package com.lemon.lemonmovies.model.detail;

import com.lemon.lemonmovies.model.detail.credits.PersonCreditDataModel;

import java.util.List;

/**
 * Model that represents TvShowDetail in presentation-layer
 */
public final class TvShowDetailDataModel {

    private final int mTvShowId;
    private final String mTvShowPoster;
    private final String mTvShowPosterPreview;
    private final String mTvShowTitle;
    private final String mTvShowOriginalTitle;
    private final String mTvShowReleaseDate;
    private final List<String> mTvShowGenres;
    private final List<String> mTvShowAllPosters;
    private final String mTvShowDescription;
    private final String mTvShowStatus;
    private final boolean mTvShowInProduction;
    private final String mTvShowInfo;
    private final String mTvShowNetworkInfo;
    private final String mTvShowRating;
    private final String mTvShowTmdbRating;
    private final String mTvShowVotesCount;
    private final boolean mTvShowWatchlist;
    private final boolean mTvShowFavorite;
    private final List<PersonCreditDataModel> mTvShowCreators;
    private final List<PersonCreditDataModel> mTvShowActors;

    private TvShowDetailDataModel(final Builder builder) {
        this.mTvShowId = builder.id;
        this.mTvShowPoster = builder.poster;
        this.mTvShowPosterPreview = builder.posterPreview;
        this.mTvShowTitle = builder.title;
        this.mTvShowOriginalTitle = builder.originalTitle;
        this.mTvShowReleaseDate = builder.releaseDate;
        this.mTvShowGenres = builder.genres;
        this.mTvShowAllPosters = builder.allPosters;
        this.mTvShowDescription = builder.description;
        this.mTvShowStatus = builder.status;
        this.mTvShowInProduction = builder.inProduction;
        this.mTvShowInfo = builder.info;
        this.mTvShowNetworkInfo = builder.networkInfo;
        this.mTvShowRating = builder.rating;
        this.mTvShowTmdbRating = builder.tmdbRating;
        this.mTvShowVotesCount = builder.votesCount;
        this.mTvShowWatchlist = builder.watchlist;
        this.mTvShowFavorite = builder.favorite;
        this.mTvShowCreators = builder.creators;
        this.mTvShowActors = builder.actors;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getTvShowId() {
        return mTvShowId;
    }

    public String getTvShowPoster() {
        return mTvShowPoster;
    }

    public String getTvShowPosterPreview() {
        return mTvShowPosterPreview;
    }

    public String getTvShowTitle() {
        return mTvShowTitle;
    }

    public String getTvShowOriginalTitle() {
        return mTvShowOriginalTitle;
    }

    public String getTvShowReleaseDate() {
        return mTvShowReleaseDate;
    }

    public List<String> getTvShowGenres() {
        return mTvShowGenres;
    }

    public List<String> getAllTvShowPosters() {
        return mTvShowAllPosters;
    }

    public String getTvShowDescription() {
        return mTvShowDescription;
    }

    public String getTvShowStatus() {
        return mTvShowStatus;
    }

    public boolean getTvShowIsInProduction() {
        return mTvShowInProduction;
    }

    public String getTvShowInfo() {
        return mTvShowInfo;
    }

    public String getTvShowNetworkInfo() {
        return mTvShowNetworkInfo;
    }

    public String getTvShowRating() {
        return mTvShowRating;
    }

    public String getTvShowTmdbRating() {
        return mTvShowTmdbRating;
    }

    public String getTvShowVotesCount() {
        return mTvShowVotesCount;
    }

    public boolean isTvShowWatchlist() {
        return mTvShowWatchlist;
    }

    public boolean isTvShowFavorite() {
        return mTvShowFavorite;
    }

    public List<PersonCreditDataModel> getTvShowCreators() {
        return mTvShowCreators;
    }

    public List<PersonCreditDataModel> getTvShowActors() {
        return mTvShowActors;
    }

    public static final class Builder {

        private int id;
        private String poster;
        private String posterPreview;
        private String title;
        private String originalTitle;
        private String releaseDate;
        private List<String> genres;
        private List<String> allPosters;
        private String description;
        private String status;
        private boolean inProduction;
        private String info;
        private String networkInfo;
        private String rating;
        private String tmdbRating;
        private String votesCount;
        private boolean watchlist;
        private boolean favorite;
        private List<PersonCreditDataModel> creators;
        private List<PersonCreditDataModel> actors;

        private Builder() {

        }

        public Builder setId(final int mId) {
            this.id = mId;
            return this;
        }

        public Builder setPoster(final String poster) {
            this.poster = poster;
            return this;
        }

        public Builder setPosterPreview(final String posterPreview) {
            this.posterPreview = posterPreview;
            return this;
        }

        public Builder setTitle(final String title) {
            this.title = title;
            return this;
        }

        public Builder setOriginalTitle(final String originalTitle) {
            this.originalTitle = originalTitle;
            return this;
        }

        public Builder setReleaseDate(final String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder setGenres(final List<String> genres) {
            this.genres = genres;
            return this;
        }

        public Builder setAllPosters(final List<String> allPosters) {
            this.allPosters = allPosters;
            return this;
        }

        public Builder setDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder setStatus(final String status) {
            this.status = status;
            return this;
        }

        public Builder setInProduction(final boolean isInProduction) {
            this.inProduction = isInProduction;
            return this;
        }

        public Builder setInfo(final String info) {
            this.info = info;
            return this;
        }

        public Builder setNetworkInfo(final String networkInfo) {
            this.networkInfo = networkInfo;
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

        public Builder setVotesCount(final String votesCount) {
            this.votesCount = votesCount;
            return this;
        }

        public Builder setWatchlist(final boolean isWatchlist) {
            this.watchlist = isWatchlist;
            return this;
        }

        public Builder setFavorite(final boolean isFavorite) {
            this.favorite = isFavorite;
            return this;
        }

        public Builder setCreators(final List<PersonCreditDataModel> creators) {
            this.creators = creators;
            return this;
        }

        public Builder setActors(final List<PersonCreditDataModel> actors) {
            this.actors = actors;
            return this;
        }

        public TvShowDetailDataModel build() {
            return new TvShowDetailDataModel(this);
        }
    }
}
