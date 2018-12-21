package com.lemon.lemonmovies.model.detail;

import com.lemon.lemonmovies.model.detail.credits.PersonCreditDataModel;

import java.util.List;

/**
 * Model that represents MovieDetail in presentation-layer
 */
public final class MovieDetailDataModel {

    private final int mMovieId;
    private final String mMoviePoster;
    private final String mMoviePosterPreview;
    private final String mMovieTitle;
    private final String mMovieOriginalTitle;
    private final String mMovieTagLine;
    private final String mMovieReleaseDate;
    private final List<String> mMovieGenres;
    private final List<String> mMovieAllPosters;
    private final String mMovieInfo;
    private final String mMovieDescription;
    private final String mMovieBudget;
    private final String mMovieRevenue;
    private final String mMovieRating;
    private final String mMovieTmdbRating;
    private final String mMovieVotesCount;
    private final boolean mMovieWatchlist;
    private final boolean mMovieFavorite;
    private final List<PersonCreditDataModel> mMovieCast;
    private final List<PersonCreditDataModel> mMovieCrew;

    private MovieDetailDataModel(final Builder builder) {
        this.mMovieId = builder.id;
        this.mMoviePoster = builder.poster;
        this.mMoviePosterPreview = builder.posterPreview;
        this.mMovieTitle = builder.title;
        this.mMovieOriginalTitle = builder.originalTitle;
        this.mMovieTagLine = builder.tagLine;
        this.mMovieReleaseDate = builder.releaseDate;
        this.mMovieGenres = builder.genres;
        this.mMovieAllPosters = builder.allPosters;
        this.mMovieDescription = builder.description;
        this.mMovieBudget = builder.budget;
        this.mMovieRevenue = builder.revenue;
        this.mMovieInfo = builder.info;
        this.mMovieRating = builder.rating;
        this.mMovieTmdbRating = builder.tmdbRating;
        this.mMovieVotesCount = builder.votesCount;
        this.mMovieWatchlist = builder.watchlist;
        this.mMovieFavorite = builder.favorite;
        this.mMovieCast = builder.cast;
        this.mMovieCrew = builder.crew;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getMovieId() {
        return mMovieId;
    }

    public String getMoviePoster() {
        return mMoviePoster;
    }

    public String getMoviePosterPreview() {
        return mMoviePosterPreview;
    }

    public String getMovieTitle() {
        return mMovieTitle;
    }

    public String getMovieOriginalTitle() {
        return mMovieOriginalTitle;
    }

    public String getMovieTagLine() {
        return mMovieTagLine;
    }

    public String getMovieReleaseDate() {
        return mMovieReleaseDate;
    }

    public List<String> getMovieGenres() {
        return mMovieGenres;
    }

    public List<String> getAllMoviePosters() {
        return mMovieAllPosters;
    }

    public String getMovieDescription() {
        return mMovieDescription;
    }

    public String getMovieBudget() {
        return mMovieBudget;
    }

    public String getMovieRevenue() {
        return mMovieRevenue;
    }

    public String getMovieInfo() {
        return mMovieInfo;
    }

    public String getMovieRating() {
        return mMovieRating;
    }

    public String getMovieTmdbRating() {
        return mMovieTmdbRating;
    }

    public String getMovieVotesCount() {
        return mMovieVotesCount;
    }

    public boolean isMovieWatchlist() {
        return mMovieWatchlist;
    }

    public boolean isMovieFavorite() {
        return mMovieFavorite;
    }

    public List<PersonCreditDataModel> getMovieCast() {
        return mMovieCast;
    }

    public List<PersonCreditDataModel> getMovieCrew() {
        return mMovieCrew;
    }

    public static final class Builder {

        private int id;
        private String poster;
        private String posterPreview;
        private String title;
        private String originalTitle;
        private String tagLine;
        private String releaseDate;
        private List<String> genres;
        private List<String> allPosters;
        private String info;
        private String description;
        private String budget;
        private String revenue;
        private String rating;
        private String tmdbRating;
        private String votesCount;
        private boolean watchlist;
        private boolean favorite;
        private List<PersonCreditDataModel> cast;
        private List<PersonCreditDataModel> crew;

        private Builder() {
        }

        public Builder setId(final int id) {
            this.id = id;
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

        public Builder setTagLine(final String tagLine) {
            this.tagLine = tagLine;
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

        public Builder setBudget(final String budget) {
            this.budget = budget;
            return this;
        }

        public Builder setRevenue(final String revenue) {
            this.revenue = revenue;
            return this;
        }

        public Builder setMovieInfo(final String info) {
            this.info = info;
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

        public Builder setCast(final List<PersonCreditDataModel> cast) {
            this.cast = cast;
            return this;
        }

        public Builder setCrew(final List<PersonCreditDataModel> crew) {
            this.crew = crew;
            return this;
        }

        public MovieDetailDataModel build() {
            return new MovieDetailDataModel(this);
        }
    }
}
