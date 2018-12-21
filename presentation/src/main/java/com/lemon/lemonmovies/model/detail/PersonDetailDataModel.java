package com.lemon.lemonmovies.model.detail;

import com.lemon.lemonmovies.model.detail.credits.MovieCreditDataModel;
import com.lemon.lemonmovies.model.detail.credits.TvShowCreditDataModel;

import java.util.List;

/**
 * Model that represents PersonDetail in presentation-layer
 */
public final class PersonDetailDataModel {

    private final int mPersonId;
    private final String mPersonPhoto;
    private final String mPersonPhotoPreview;
    private final String mPersonName;
    private final String mPersonBiography;
    private final String mPersonBirthday;
    private final String mPersonDeathday;
    private final String mPersonKnownAs;
    private final boolean mPersonFavorite;
    private final List<MovieCreditDataModel> mPersonMoviesList;
    private final List<TvShowCreditDataModel> mPersonTvShowsList;

    private PersonDetailDataModel(final Builder builder) {
        this.mPersonId = builder.id;
        this.mPersonPhoto = builder.photo;
        this.mPersonPhotoPreview = builder.photoPreview;
        this.mPersonName = builder.name;
        this.mPersonBiography = builder.biography;
        this.mPersonBirthday = builder.birthday;
        this.mPersonDeathday = builder.deathday;
        this.mPersonKnownAs = builder.knownAs;
        this.mPersonFavorite = builder.favorite;
        this.mPersonMoviesList = builder.movies;
        this.mPersonTvShowsList = builder.tvShows;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getPersonId() {
        return mPersonId;
    }

    public String getPersonPhoto() {
        return mPersonPhoto;
    }

    public String getPersonPhotoPreview() {
        return mPersonPhotoPreview;
    }

    public String getPersonName() {
        return mPersonName;
    }

    public String getPersonBiography() {
        return mPersonBiography;
    }

    public String getPersonBirthday() {
        return mPersonBirthday;
    }

    public String getPersonDeathday() {
        return mPersonDeathday;
    }

    public String getPersonKnownAs() {
        return mPersonKnownAs;
    }

    public boolean isPersonFavorite() {
        return mPersonFavorite;
    }

    public List<MovieCreditDataModel> getPersonMoviesList() {
        return mPersonMoviesList;
    }

    public List<TvShowCreditDataModel> getPersonTvShowsList() {
        return mPersonTvShowsList;
    }


    public static final class Builder {

        private int id;
        private String photo;
        private String photoPreview;
        private String name;
        private String biography;
        private String birthday;
        private String deathday;
        private String knownAs;
        private boolean favorite;
        private List<MovieCreditDataModel> movies;
        private List<TvShowCreditDataModel> tvShows;

        private Builder() {
        }

        public Builder setId(final int id) {
            this.id = id;
            return this;
        }

        public Builder setPhoto(final String photo) {
            this.photo = photo;
            return this;
        }

        public Builder setPhotoPreview(final String photoPreview) {
            this.photoPreview = photoPreview;
            return this;
        }

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setBiography(final String biography) {
            this.biography = biography;
            return this;
        }

        public Builder setBirthday(final String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder setDeathday(final String deathday) {
            this.deathday = deathday;
            return this;
        }

        public Builder setKnownAs(final String knownAs) {
            this.knownAs = knownAs;
            return this;
        }

        public Builder setFavorite(final boolean isFavorite) {
            this.favorite = isFavorite;
            return this;
        }

        public Builder setMovies(final List<MovieCreditDataModel> movies) {
            this.movies = movies;
            return this;
        }

        public Builder setTvShows(final List<TvShowCreditDataModel> tvShows) {
            this.tvShows = tvShows;
            return this;
        }

        public PersonDetailDataModel build() {
            return new PersonDetailDataModel(this);
        }
    }
}
